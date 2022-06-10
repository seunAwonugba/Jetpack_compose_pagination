package com.example.base.repository

import androidx.paging.PagingData
import com.example.base.ui.AllPhotosData
import kotlinx.coroutines.flow.Flow

interface AllPhotosRepository {
    suspend fun getAllPhotos(
        page : Int,
        per_page : Int,
        order_by : String
    ) : Flow<PagingData<AllPhotosData>>
}