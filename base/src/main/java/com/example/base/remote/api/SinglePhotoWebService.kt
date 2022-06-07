package com.example.base.remote.api

import com.example.base.BuildConfig
import com.example.base.Constant
import com.example.base.Constant.SEARCH_PHOTOS_ENDPOINT
import com.example.base.remote.data.UnsplashResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SinglePhotoWebService {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(SEARCH_PHOTOS_ENDPOINT)
    suspend fun getAllPhotos(
        @Query("query") query : String,
        @Query("page") page : Int,
        @Query("per_page") per_page : Int,
        @Query("order_by") order_by : String = "latest"
    ) : Response<UnsplashResponse>
}