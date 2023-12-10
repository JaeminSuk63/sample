package com.hyundai.sample.data.repository

import com.hyundai.sample.entity.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun addSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem)

    suspend fun deleteSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem)

    fun getSearchHistory(): Flow<List<com.hyundai.sample.entity.SearchHistoryItem>>

    suspend fun getApiVersion(): Int?

    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}
