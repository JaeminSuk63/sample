package com.hyundai.sample.usecase.vehicle

import com.hyundai.sample.usecase.SampleRepository

class GetIgnitionState(private val repository: SampleRepository) {
    operator fun invoke() = repository.getIgnitionState()
}