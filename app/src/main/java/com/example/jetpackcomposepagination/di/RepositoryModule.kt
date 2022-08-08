package com.example.jetpackcomposepagination.di

import com.example.base.db.AllPhotosDataBase
import com.example.base.db.AllPhotosDataDao
import com.example.base.remote.api.AllPhotosWebService
import com.example.base.remote.api.SinglePhotoWebService
import com.example.base.repository.AllPhotosRepository
import com.example.base.repository.AllPhotosRepositoryImpl
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
    fun provideSinglePhotosWebService(retrofit: Retrofit) : SinglePhotoWebService = retrofit.create()

    @Singleton
    @Provides
    fun provideMyAllPhotosRepository(
        allPhotosWebService: AllPhotosWebService,
        allPhotosDataBase: AllPhotosDataBase
    ) : AllPhotosRepository = AllPhotosRepositoryImpl(
        allPhotosWebService = allPhotosWebService,
        allPhotosDataBase = allPhotosDataBase
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