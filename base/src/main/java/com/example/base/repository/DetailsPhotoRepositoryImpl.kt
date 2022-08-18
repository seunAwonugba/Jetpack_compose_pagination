package com.example.base.repository

import com.example.base.remote.api.DetailsPhotoWebService
import com.example.base.remote.data.details.DetailsPhotoDto
import com.example.base.ui.DetailsPhoto
import retrofit2.Response
import javax.inject.Inject

class DetailsPhotoRepositoryImpl @Inject constructor (
    private val detailsPhotoWebService: DetailsPhotoWebService
    ) : DetailsPhotoRepository{

        override suspend fun getPhoto(userId: String): DetailsPhoto {
        val data = detailsPhotoWebService.getPhoto(id = userId)
        return data.toDetailsPhoto()
    }
//    override suspend fun getPhoto(userId: String) = detailsPhotoWebService.getPhoto(id = userId)


//    override suspend fun getDataFromApiInTestRepository(
//        countryCode: String,
//        pageNumber: Int
//    ) = apiInterface.getHeadlineNewsInInterface(countryCode, pageNumber)
}


private fun DetailsPhotoDto.toDetailsPhoto() =
    DetailsPhoto(id = this.id, name = this.user.name, profileImage = this.user.profile_image.large)

