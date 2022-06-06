package com.example.base.ui

import androidx.room.Entity
import com.example.base.Constant.UNSPLASH_DB_TABLE

@Entity(tableName = UNSPLASH_DB_TABLE)
data class AllPhotosData(
    val id : String,
    val images : String,
    val likes : Int,
    val user : String
)
