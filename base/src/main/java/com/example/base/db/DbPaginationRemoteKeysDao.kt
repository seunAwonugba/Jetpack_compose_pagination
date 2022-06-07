package com.example.base.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.base.Constant.DB_PAGINATION_REMOTE_KEYS_TABLE

@Dao
interface DbPaginationRemoteKeysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertDbRemoteKeys(remoteKeysDao: DbPaginationRemoteKeysDao)

    @Query("SELECT * FROM $DB_PAGINATION_REMOTE_KEYS_TABLE WHERE id=:id")
    suspend fun getDbRemoteKeys(id : String) : List<DbPaginationRemoteKeys>

    @Query("DELETE FROM $DB_PAGINATION_REMOTE_KEYS_TABLE")
    suspend fun deleteAllDbRemoteKeys()

}