package com.hyundai.sample.core.domain.useCases

import com.hyundai.sample.core.domain.Repository

class GetSearchHistory(private val repository: Repository) {
    operator fun invoke() = repository.getSearchHistory()
}