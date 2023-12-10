package com.hyundai.sample.domain.useCases

import com.hyundai.sample.data.repository.Repository
import com.hyundai.sample.entity.SearchHistoryItem

class DeleteSearchHistory(private val repository: Repository) {
    suspend operator fun invoke(item: com.hyundai.sample.entity.SearchHistoryItem) =
        repository.deleteSearchHistory(item)
}