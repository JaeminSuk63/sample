package com.hyundai.sample.entity

data class SearchHistoryItem(
    val key: Long = 0,
    val keyword: String,
    val createdDateTime: Long = System.currentTimeMillis()
)
