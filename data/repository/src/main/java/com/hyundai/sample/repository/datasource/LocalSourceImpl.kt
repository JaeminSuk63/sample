package com.hyundai.sample.repository.datasource

import com.hyundai.sample.db.Database
import com.hyundai.sample.db.toDbEntity
import com.hyundai.sample.db.toEntity
import com.hyundai.sample.entity.SearchHistoryItem
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