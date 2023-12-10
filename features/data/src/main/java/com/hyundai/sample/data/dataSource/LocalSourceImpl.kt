package com.hyundai.sample.data.dataSource

import com.hyundai.sample.data.db.Database
import com.hyundai.sample.data.db.toDbEntity
import com.hyundai.sample.data.db.toEntity
import com.hyundai.sample.entity.SearchHistoryItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalSourceImpl(private val database: Database) : LocalSource {
    override suspend fun addSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem) {
        database.searchHistoryDao().insertItem(item.toDbEntity())
    }

    override suspend fun deleteSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem) {
        database.searchHistoryDao().deleteItem(item.toDbEntity())
    }

    override fun getSearchHistory(): Flow<List<com.hyundai.sample.entity.SearchHistoryItem>> {
        return database.searchHistoryDao().getAll().map { it.toEntity() }
    }
}