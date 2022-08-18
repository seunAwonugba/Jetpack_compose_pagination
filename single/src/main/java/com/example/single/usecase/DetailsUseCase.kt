package com.example.single.usecase

import android.util.Log
import com.example.base.repository.DetailsPhotoRepository
import com.example.base.ui.DetailsPhoto
import com.example.base.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DetailsUseCase @Inject constructor(
    private val detailsPhotoRepository: DetailsPhotoRepository
) {
    //use case must only have one public function

    operator fun invoke(userId : String) : Flow<Resource<DetailsPhoto>> = flow {
        try {
            emit(Resource.Loading())
            val photoDetails = detailsPhotoRepository.getPhoto(userId = userId)
            emit(Resource.Success(photoDetails))
        }catch (err : IOException){
            emit(Resource.Error("$err"))
        }catch (err : HttpException){
            emit(Resource.Error("$err"))
        }
    }
}