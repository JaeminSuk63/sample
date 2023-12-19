package com.hyundai.sample.usecase.cloud

import com.hyundai.sample.usecase.SampleRepository

class GetApiVersion(private val repository: SampleRepository) {
    suspend operator fun invoke() = repository.getApiVersion()
}