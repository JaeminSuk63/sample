package com.hyundai.sample.core.data.dataSources

import com.hyundai.sample.core.domain.SearchHistoryItem

interface LocalSource {
    fun addSearchHistory(item: SearchHistoryItem)

    fun deleteSearchHistory(item: SearchHistoryItem)

    fun getSearchHistory(): List<SearchHistoryItem>
}