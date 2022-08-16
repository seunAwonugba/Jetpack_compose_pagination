package com.example.base.repository

import com.example.base.resource.Resource
import com.example.base.ui.DetailsPhoto
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface DetailsPhotoRepository {

    suspend fun getPhoto(userId : String): DetailsPhoto
}