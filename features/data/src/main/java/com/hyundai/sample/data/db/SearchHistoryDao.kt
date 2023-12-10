package com.hyundai.sample.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchHistoryDao {

    @Query("SELECT * FROM search_history")
    fun getAll(): Flow<List<SearchHistoryDbEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: SearchHistoryDbEntity)

    @Delete
    suspend fun deleteItem(item: SearchHistoryDbEntity)
}