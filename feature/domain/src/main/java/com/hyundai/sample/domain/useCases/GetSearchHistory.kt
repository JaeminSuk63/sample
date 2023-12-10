package com.hyundai.sample.domain.useCases

import com.hyundai.sample.repository.Repository

class GetSearchHistory(private val repository: Repository) {
    operator fun invoke() = repository.getSearchHistory()
}