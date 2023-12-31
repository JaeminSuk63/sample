package com.hyundai.sample.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SearchHistoryDbEntity::class],
    version = 1,
    exportSchema = false
)
abstract class Database : RoomDatabase() {
    abstract fun searchHistoryDao(): SearchHistoryDao
}