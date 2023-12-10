package com.hyundai.sample.data.dataSource

import com.hyundai.sample.entity.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    suspend fun addSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem)

    suspend fun deleteSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem)

    fun getSearchHistory(): Flow<List<com.hyundai.sample.entity.SearchHistoryItem>>
}