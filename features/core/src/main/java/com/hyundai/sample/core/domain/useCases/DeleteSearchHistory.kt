package com.hyundai.sample.core.domain.useCases

import com.hyundai.sample.core.data.repository.Repository
import com.hyundai.sample.core.domain.SearchHistoryItem

class DeleteSearchHistory(private val repository: Repository) {
    suspend operator fun invoke(item: SearchHistoryItem) = repository.deleteSearchHistory(item)
}