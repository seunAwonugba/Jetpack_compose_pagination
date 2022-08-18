package com.example.base.remote.api

import com.example.base.BuildConfig
import com.example.base.Constant.GET_ALL_PHOTOS_END_POINT
import com.example.base.Constant.SEARCH_PHOTOS_ENDPOINT
import com.example.base.remote.data.allphotos.UnsplashResponseDto
import com.example.base.remote.data.search.SearchRequestDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AllPhotosWebService {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(GET_ALL_PHOTOS_END_POINT)
    suspend fun getAllPhotos(
        @Query("page") page : Int,
        @Query("per_page") per_page : Int,
        @Query("order_by") order_by : String = "latest"
    ) : Response<UnsplashResponseDto>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(SEARCH_PHOTOS_ENDPOINT)
    suspend fun searchImages(
        @Query("query") query : String,
        @Query("per_page") per_page : Int,
        @Query("order_by") order_by : String = "latest"
    ) : Response<SearchRequestDto>
}