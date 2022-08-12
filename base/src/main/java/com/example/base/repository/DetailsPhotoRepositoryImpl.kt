package com.example.base.repository

import com.example.base.remote.api.DetailsPhotoWebService
import com.example.base.remote.data.details.DetailsPhotoDto
import com.example.base.ui.DetailsPhoto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DetailsPhotoRepositoryImpl @Inject constructor (
    private val detailsPhotoWebService: DetailsPhotoWebService
    ) : DetailsPhotoRepository{

    override fun getPhoto(userId: String): Flow<DetailsPhoto> = flow{
        val data = detailsPhotoWebService.getPhoto(id = userId)
        emit(data.run {
            DetailsPhoto(id = id, name = user.name)
        })
//        //or
//        emit(data.toDetailsPhoto())


    }

}

fun DetailsPhotoDto.toDetailsPhoto() =
    DetailsPhoto(id = this.id, name = this.user.name)