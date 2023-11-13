package com.hyundai.sample.core.domain.useCases

import com.hyundai.sample.core.domain.Repository
import com.hyundai.sample.core.domain.SearchHistoryItem

class DeleteSearchHistory(private val repository: Repository) {
    operator fun invoke(item: SearchHistoryItem) = repository.deleteSearchHistory(item)
}