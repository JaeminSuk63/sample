package com.hyundai.sample.db

import com.hyundai.sample.entity.SearchHistoryItem


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