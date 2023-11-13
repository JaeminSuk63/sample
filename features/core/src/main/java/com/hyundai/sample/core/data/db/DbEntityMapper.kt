package com.hyundai.sample.core.data.db

import com.hyundai.sample.core.domain.SearchHistoryItem

fun List<SearchHistoryDbEntity>.toEntity(): List<SearchHistoryItem> {
    return map { dbEntity ->
        SearchHistoryItem(
            key = dbEntity.key,
            keyword = dbEntity.keyword,
            createdDateTime = dbEntity.createdDateTime,
        )
    }
}


fun SearchHistoryItem.toDbEntity(): SearchHistoryDbEntity {
    return SearchHistoryDbEntity(
        key = this.key,
        keyword = this.keyword,
        createdDateTime = this.createdDateTime,
    )
}