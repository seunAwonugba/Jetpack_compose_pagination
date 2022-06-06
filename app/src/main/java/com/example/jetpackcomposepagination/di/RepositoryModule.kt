package com.example.jetpackcomposepagination.di

import com.example.base.remote.api.AllPhotosWebService
import com.example.base.remote.api.SinglePhotoWebService
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
}