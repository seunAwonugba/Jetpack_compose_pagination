package com.example.base.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.base.ui.AllPhotosData


//in the DB class, u must specify all your DB table
@Database(
    entities = [AllPhotosData::class, DbPaginationRemoteKeys::class],
    version = 1
)
abstract class AllPhotosDataBase : RoomDatabase() {

    abstract fun allPhotosDataDao() : AllPhotosDataDao
    abstract fun dbPaginationRemoteKeysDao() : DbPaginationRemoteKeysDao
}