package com.example.base.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.base.db.AllPhotosDataBase
import com.example.base.db.DbPaginationRemoteKeys
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.ui.AllPhotosData
import javax.inject.Inject

@OptIn(ExperimentalPagingApi::class)
class AllPhotosDataRemoteMediator(
    //to provide instance of these two classes has been done in the di package above
    private val allPhotosWebService: AllPhotosWebService,
    private val allPhotosDataBase: AllPhotosDataBase
) : RemoteMediator<Int, AllPhotosData>(){

    //these two  variables will be used from the load function below to save data from api
    //remote keys tell remote mediator which page to load next

    private val allPhotosDataDao= allPhotosDataBase.allPhotosDataDao()
    private val dbPaginationRemoteKeysDao = allPhotosDataBase.dbPaginationRemoteKeysDao()

    override suspend fun initialize(): InitializeAction {
        // Require that remote REFRESH is launched on initial load and succeeds before launching
        // remote PREPEND / APPEND.
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, AllPhotosData>
    ): MediatorResult {
        return try {
            //this variable is used to calculate previous and next page keys, we need to know the current page value
            val currentPage = when(loadType){
                //this runs the first time u make request to server, so if nextPage value is null
                    // from remote keys db table the a default value for our curent page will be one
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }
                //load data at the start of paging data
                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }
                //loads data at the end of the paging data
                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }

            }

            //making api request to just determine pagination
            val response = allPhotosWebService.getAllPhotos(page = currentPage, per_page = 10)

            val endOfPaginationReached = response.body()?.isEmpty()

            val prevPage = if (currentPage == 1) null else currentPage - 1
            val nextPage = if (endOfPaginationReached == true) null else currentPage + 1

            allPhotosDataBase.withTransaction {
                if (loadType == LoadType.REFRESH){
                    allPhotosDataDao.deleteAllDataFromDb()
                    dbPaginationRemoteKeysDao.deleteAllDbRemoteKeys()
                }
                val keys = response.body()?.map {
                    DbPaginationRemoteKeys(
                        id = it.id,
                        prevPage = prevPage,
                        nextPage = nextPage
                    )
                }

                if (keys != null) {
                    dbPaginationRemoteKeysDao.upsertDbRemoteKeys(remoteKeysDao = keys)
                }
                if (response.isSuccessful && response.body() != null){
                    response.body()?.map {
                        AllPhotosData(
                            id = it.id,
                            images = it.urls.regular,
                            likes = it.likes,
                            user = "${it.user.first_name} ${it.user.last_name}",
                            userName = it.user.username
                        )
                    }?.let { allPhotosDataDao.upsert(allPhotosData = it) }
                }
            }
            MediatorResult.Success(endOfPaginationReached == true)
        }catch (err : Exception){
            return MediatorResult.Error(err)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, AllPhotosData>
    ) : DbPaginationRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                dbPaginationRemoteKeysDao.getDbRemoteKeys(id = id)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(
        state : PagingState<Int, AllPhotosData>
    ) : DbPaginationRemoteKeys? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        } ?.data?.firstOrNull() ?.let { allPhotosData ->
            dbPaginationRemoteKeysDao.getDbRemoteKeys(id = allPhotosData.id)
        }
    }

    private suspend fun getRemoteKeyForLastItem(
        state: PagingState<Int, AllPhotosData>
    ) : DbPaginationRemoteKeys? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        } ?.data?.lastOrNull() ?.let { allPhotosData ->
            dbPaginationRemoteKeysDao.getDbRemoteKeys(id = allPhotosData.id)
        }
    }


}