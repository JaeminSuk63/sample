package com.hyundai.sample.repository.datasource

import com.hyundai.sample.entity.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    suspend fun addSearchHistory(item: SearchHistoryItem)

    suspend fun deleteSearchHistory(item: SearchHistoryItem)

    fun getSearchHistory(): Flow<List<SearchHistoryItem>>
}