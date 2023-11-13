package com.hyundai.sample.core.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "search_history")
data class SearchHistoryDbEntity(
    @PrimaryKey(autoGenerate = true)
    val key: Long,
    val keyword: String,
    val createdDateTime: Long
)