package com.example.base.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.base.Constant.ITEMS_PER_PAGE
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.ui.AllPhotosData

class SearchPagingSource(
    private val allPhotosWebService: AllPhotosWebService,
    private val query : String
) : PagingSource<Int, AllPhotosData>() {

    override fun getRefreshKey(state: PagingState<Int, AllPhotosData>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AllPhotosData> {
        val currentPage = params.key ?: 1
        return try {
            val response = allPhotosWebService.searchImages(query = query, per_page = ITEMS_PER_PAGE)
            val endOfPaginationReached = response.body()?.results?.isEmpty()

            if (response.body()?.results?.isNotEmpty() == true){
                LoadResult.Page(
                    data = response.body()!!.results.map {
                        AllPhotosData(
                            id = it.id,
                            images = it.urls.regular,
                            likes = it.likes,
                            user = "${it.user.last_name} ${it.user.first_name} ",
                            userName = it.user.username
                        )
                    },
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached == true) null else currentPage + 1
                )
            }else{
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        }catch (e : Exception){
            LoadResult.Error(e)
        }
    }
}
