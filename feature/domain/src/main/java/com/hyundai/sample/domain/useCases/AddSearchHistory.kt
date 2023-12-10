package com.hyundai.sample.domain.useCases

import com.hyundai.sample.repository.Repository

class AddSearchHistory(private val repository: Repository) {
    suspend operator fun invoke(item: com.hyundai.sample.entity.SearchHistoryItem) =
        repository.addSearchHistory(item)
}