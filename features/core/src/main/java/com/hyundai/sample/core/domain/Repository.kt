package com.hyundai.sample.core.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    fun addSearchHistory(item: SearchHistoryItem)

    fun deleteSearchHistory(item: SearchHistoryItem)

    fun getSearchHistory(): List<SearchHistoryItem>

    suspend fun getApiVersion(): Int?

    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}
