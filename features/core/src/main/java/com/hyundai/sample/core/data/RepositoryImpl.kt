package com.hyundai.sample.core.data

import com.hyundai.sample.core.domain.Repository
import com.hyundai.sample.core.domain.SearchHistoryItem
import kotlinx.coroutines.flow.flow

class RepositoryImpl : Repository {
    override fun addSearchHistory(item: SearchHistoryItem) {

    }

    override fun deleteSearchHistory(item: SearchHistoryItem) {

    }

    override fun getApiVersion() = 0

    override fun getIgnitionState() = flow<Int?> { emit(0) }

    override fun getSearchHistory() = emptyList<SearchHistoryItem>()

    override fun isParkingBrakeOn() = false
}