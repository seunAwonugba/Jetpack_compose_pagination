package com.example.jetpackcomposepagination.di

import com.example.base.db.AllPhotosDataBase
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.remote.api.DetailsPhotoWebService
import com.example.base.repository.AllPhotosRepository
import com.example.base.repository.AllPhotosRepositoryImpl
import com.example.base.repository.DetailsPhotoRepository
import com.example.base.repository.DetailsPhotoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAllPhotosWebService(retrofit: Retrofit) : AllPhotosWebService = retrofit.create()

    @Singleton
    @Provides
    fun provideDetailsPhotosWebService(retrofit: Retrofit) : DetailsPhotoWebService = retrofit.create()

    @Singleton
    @Provides
    fun provideMyAllPhotosRepository(
        allPhotosWebService: AllPhotosWebService,
        allPhotosDataBase: AllPhotosDataBase
    ) : AllPhotosRepository = AllPhotosRepositoryImpl(
        allPhotosWebService = allPhotosWebService,
        allPhotosDataBase = allPhotosDataBase
    )

    @Singleton
    @Provides
    fun providePhotoDetailsRepository(
        detailsPhotoWebService: DetailsPhotoWebService,
    ) : DetailsPhotoRepository = DetailsPhotoRepositoryImpl(
        detailsPhotoWebService = detailsPhotoWebService,
    )

//    @Singleton
//    @Provides
//    fun provideAllPhotosRepository(
//        allPhotosWebService: AllPhotosWebService,
//        allPhotosDataBase: AllPhotosDataBase
//    ) : AllPhotosRepository = AllPhotosRepositoryImpl(
//        allPhotosWebService = allPhotosWebService ,
//        allPhotosDataBase = allPhotosDataBase)

}