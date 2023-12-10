package com.hyundai.sample.domain.useCases

import com.hyundai.sample.data.repository.Repository

class GetApiVersion(private val repository: Repository) {
    suspend operator fun invoke() = repository.getApiVersion()
}