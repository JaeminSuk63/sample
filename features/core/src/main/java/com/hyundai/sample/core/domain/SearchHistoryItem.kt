package com.hyundai.sample.core.domain

data class SearchHistoryItem(
    val key: Long = 0,
    val keyword: String,
    val createdDateTime: Long = System.currentTimeMillis()
)
