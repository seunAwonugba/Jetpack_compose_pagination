package com.example.jetpackcomposepagination.di

import android.content.Context
import androidx.room.Room
import com.example.base.Constant.ALL_PHOTOS_DATABASE
import com.example.base.db.AllPhotosDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideAllPhotosDataBase(@ApplicationContext context: Context) : AllPhotosDataBase {
        return Room.databaseBuilder(
            context = context,
            AllPhotosDataBase::class.java,
            ALL_PHOTOS_DATABASE
        ).build()
    }
}