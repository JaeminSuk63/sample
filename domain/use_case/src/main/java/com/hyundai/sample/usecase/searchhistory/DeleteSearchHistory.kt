package com.hyundai.sample.usecase.searchhistory

import com.hyundai.sample.entity.SearchHistoryItem
import com.hyundai.sample.usecase.SampleRepository

class DeleteSearchHistory(private val repository: SampleRepository) {
    suspend operator fun invoke(item: SearchHistoryItem) =
        repository.deleteSearchHistory(item)
}