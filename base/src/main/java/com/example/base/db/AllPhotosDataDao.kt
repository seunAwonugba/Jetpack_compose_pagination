package com.example.base.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.base.ui.AllPhotosData

@Dao
interface AllPhotosDataDao {

    //first add data to DB
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(allPhotosData: AllPhotosData)

    //by using paging source, it alo means we'll be able to paginate via our db also with our paging
    //library
    @Query("SELECT * FROM unsplash_db_table")
    fun fetchDataFromDb() : PagingSource<Int, AllPhotosData>

    @Query("DELETE FROM unsplash_db_table")
    suspend fun deleteAllDataFromDb()
}