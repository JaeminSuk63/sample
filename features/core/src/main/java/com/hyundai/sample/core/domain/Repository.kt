package com.hyundai.sample.core.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun addSearchHistory(item: SearchHistoryItem)

    fun deleteSearchHistory(item: SearchHistoryItem)

    fun getApiVersion(): Int?

    fun getIgnitionState(): Flow<Int?>

    fun getSearchHistory(): List<SearchHistoryItem>

    fun isParkingBrakeOn(): Boolean
}