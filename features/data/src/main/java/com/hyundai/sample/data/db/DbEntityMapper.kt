package com.hyundai.sample.data.db

import com.hyundai.sample.entity.SearchHistoryItem


fun List<SearchHistoryDbEntity>.toEntity(): List<com.hyundai.sample.entity.SearchHistoryItem> {
    return map { dbEntity ->
        com.hyundai.sample.entity.SearchHistoryItem(
            key = dbEntity.key,
            keyword = dbEntity.keyword,
            createdDateTime = dbEntity.createdDateTime,
        )
    }
}


fun com.hyundai.sample.entity.SearchHistoryItem.toDbEntity(): SearchHistoryDbEntity {
    return SearchHistoryDbEntity(
        key = this.key,
        keyword = this.keyword,
        createdDateTime = this.createdDateTime,
    )
}