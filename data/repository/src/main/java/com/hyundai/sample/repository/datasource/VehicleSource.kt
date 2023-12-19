package com.hyundai.sample.repository.datasource

import kotlinx.coroutines.flow.Flow

interface VehicleSource {
    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}