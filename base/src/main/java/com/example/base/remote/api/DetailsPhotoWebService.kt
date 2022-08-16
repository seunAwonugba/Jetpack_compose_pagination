package com.example.base.remote.api

import com.example.base.BuildConfig
import com.example.base.Constant.GET_SINGLE_PHOTO_END_POINT
import com.example.base.remote.data.details.DetailsPhotoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailsPhotoWebService {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET(GET_SINGLE_PHOTO_END_POINT)
    suspend fun getPhoto(
        @Path("id") id : String
    ) : DetailsPhotoDto

//    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
//    @GET(GET_SINGLE_PHOTO_END_POINT)
//    suspend fun getPhoto(
//        @Query("query") query : String,
//        @Query("page") page : Int,
//        @Query("per_page") per_page : Int,
//        @Query("order_by") order_by : String = "latest"
//    ) : Response<DetailsPhotoDto>
}

