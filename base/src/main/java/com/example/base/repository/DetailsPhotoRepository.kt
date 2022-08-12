package com.example.base.repository

import com.example.base.ui.DetailsPhoto
import kotlinx.coroutines.flow.Flow

interface DetailsPhotoRepository {

    fun getPhoto(userId : String): Flow<DetailsPhoto>
}