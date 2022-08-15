package com.example.base.repository

import com.example.base.remote.api.DetailsPhotoWebService
import com.example.base.remote.data.details.DetailsPhotoDto
import com.example.base.ui.DetailsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class DetailsPhotoRepositoryImpl @Inject constructor (
    private val detailsPhotoWebService: DetailsPhotoWebService
    ) : DetailsPhotoRepository{

    //    override fun getPhoto(userId: String): DetailsPhoto = flow{
//        Log.e("DID_U_RUN", "yes u ran")
//        val data = detailsPhotoWebService.getPhoto(id = userId)
//        Log.e("REPO_FETCHED_DATA", data.toString())
////        emit(data.run {
////            DetailsPhoto(id = id, name = user.name)
////        })
////        //or
//        emit(data.toDetailsPhoto())
//
//
//    }.flowOn(Dispatchers.IO)
    override suspend fun getPhoto(userId: String): List<DetailsPhoto> {
        val data = detailsPhotoWebService.getPhoto(id = userId)
        return data.map {
            DetailsPhoto(
                id = it.id,
                name = it.user.name
            )
        }
//        data.toDetailsPhoto()
//        return data.run { DetailsPhoto(
//            id = data.id,
//            name = data.user.name
//        ) }
    }

}


fun DetailsPhotoDto.toDetailsPhoto() =
    DetailsPhoto(id = this.id, name = this.user.name)

