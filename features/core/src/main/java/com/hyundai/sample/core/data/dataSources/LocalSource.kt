package com.hyundai.sample.core.data.dataSources

import com.hyundai.sample.core.domain.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface LocalSource {
    suspend fun addSearchHistory(item: SearchHistoryItem)

    suspend fun deleteSearchHistory(item: SearchHistoryItem)

    fun getSearchHistory(): Flow<List<SearchHistoryItem>>
}