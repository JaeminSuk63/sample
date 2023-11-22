package com.hyundai.sample.core.domain.useCases

import com.hyundai.sample.core.data.repository.Repository

class GetSearchHistory(private val repository: Repository) {
    operator fun invoke() = repository.getSearchHistory()
}