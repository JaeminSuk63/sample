package com.hyundai.sample.core.domain

import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun addSearchHistory(item: SearchHistoryItem)

    suspend fun deleteSearchHistory(item: SearchHistoryItem)

    fun getSearchHistory(): List<SearchHistoryItem>

    suspend fun getApiVersion(): Int?

    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}
