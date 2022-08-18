package com.example.base.repository

import androidx.paging.PagingData
import com.example.base.ui.AllPhotosData
import kotlinx.coroutines.flow.Flow

interface AllPhotosRepository {
    fun getAllPhotos() : Flow<PagingData<AllPhotosData>>

    fun searchAllPhotos(query : String) : Flow<PagingData<AllPhotosData>>
}