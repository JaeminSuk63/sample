package com.hyundai.sample.usecase.searchhistory

import com.hyundai.sample.entity.SearchHistoryItem
import com.hyundai.sample.usecase.SampleRepository

class AddSearchHistory(private val repository: SampleRepository) {
    suspend operator fun invoke(item: SearchHistoryItem) =
        repository.addSearchHistory(item)
}