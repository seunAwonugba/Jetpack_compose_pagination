package com.example.base.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.base.Constant.ITEMS_PER_PAGE
import com.example.base.db.AllPhotosDataBase
import com.example.base.paging.AllPhotosDataRemoteMediator
import com.example.base.paging.SearchPagingSource
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.ui.AllPhotosData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AllPhotosRepositoryImpl @Inject constructor(
    private val allPhotosWebService: AllPhotosWebService,
    private val allPhotosDataBase: AllPhotosDataBase
) : AllPhotosRepository {
    @OptIn(ExperimentalPagingApi::class)

    override fun getAllPhotos(): Flow<PagingData<AllPhotosData>> {
        val pagingSourceFactory = {allPhotosDataBase.allPhotosDataDao().fetchDataFromDb()}

        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = true
            ),
            //we use remote mediator to fetch data from api, and store the response into db
            remoteMediator = AllPhotosDataRemoteMediator(
                allPhotosWebService = allPhotosWebService,
                allPhotosDataBase = allPhotosDataBase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun searchAllPhotos(query: String): Flow<PagingData<AllPhotosData>> {
        return Pager(
            config = PagingConfig(
                pageSize = ITEMS_PER_PAGE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                SearchPagingSource(allPhotosWebService = allPhotosWebService, query = query)
            }
        ).flow
    }
}