package com.hyundai.sample.domain.useCases

import com.hyundai.sample.data.repository.Repository

class GetIgnitionState(private val repository: Repository) {
    operator fun invoke() = repository.getIgnitionState()
}