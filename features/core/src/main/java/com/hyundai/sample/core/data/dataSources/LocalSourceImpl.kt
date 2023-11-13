package com.hyundai.sample.core.data.dataSources

import com.hyundai.sample.core.data.db.Database
import com.hyundai.sample.core.data.db.toDbEntity
import com.hyundai.sample.core.data.db.toEntity
import com.hyundai.sample.core.domain.SearchHistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalSourceImpl(private val database: Database) : LocalSource {
    override suspend fun addSearchHistory(item: SearchHistoryItem) {
        database.searchHistoryDao().insertItem(item.toDbEntity())
    }

    override suspend fun deleteSearchHistory(item: SearchHistoryItem) {
        database.searchHistoryDao().deleteItem(item.toDbEntity())
    }

    override fun getSearchHistory(): Flow<List<SearchHistoryItem>> {
        return database.searchHistoryDao().getAll().map { it.toEntity() }
    }
}