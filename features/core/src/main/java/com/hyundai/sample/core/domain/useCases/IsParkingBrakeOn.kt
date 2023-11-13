package com.hyundai.sample.core.domain.useCases

import com.hyundai.sample.core.domain.Repository

class IsParkingBrakeOn(private val repository: Repository) {
    operator fun invoke() = repository.isParkingBrakeOn()
}