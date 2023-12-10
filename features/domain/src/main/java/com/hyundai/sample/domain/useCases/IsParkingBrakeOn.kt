package com.hyundai.sample.domain.useCases

import com.hyundai.sample.data.repository.Repository

class IsParkingBrakeOn(private val repository: Repository) {
    operator fun invoke() = repository.isParkingBrakeOn()
}