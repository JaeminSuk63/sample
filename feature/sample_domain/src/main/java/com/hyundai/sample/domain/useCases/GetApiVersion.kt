package com.hyundai.sample.domain.useCases

import com.hyundai.sample.repository.Repository

class GetApiVersion(private val repository: Repository) {
    suspend operator fun invoke() = repository.getApiVersion()
}