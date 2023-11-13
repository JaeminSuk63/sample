package com.hyundai.sample.core.domain.useCases

import com.hyundai.sample.core.domain.Repository

class GetApiVersion(private val repository: Repository) {
    suspend operator fun invoke() = repository.getApiVersion()
}