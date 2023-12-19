package com.hyundai.sample.usecase

import com.hyundai.sample.entity.SearchHistoryItem
import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    suspend fun addSearchHistory(item: SearchHistoryItem)

    suspend fun deleteSearchHistory(item: SearchHistoryItem)

    fun getSearchHistory(): Flow<List<SearchHistoryItem>>

    suspend fun getApiVersion(): Int?

    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}
