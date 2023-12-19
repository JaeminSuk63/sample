package com.hyundai.sample.usecase.vehicle

import com.hyundai.sample.usecase.SampleRepository

class IsParkingBrakeOn(private val repository: SampleRepository) {
    operator fun invoke() = repository.isParkingBrakeOn()
}