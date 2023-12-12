package com.hyundai.sample.domain.useCases

import com.hyundai.sample.repository.Repository

class IsParkingBrakeOn(private val repository: Repository) {
    operator fun invoke() = repository.isParkingBrakeOn()
}