package com.hyundai.sample.repository.dataSource

import kotlinx.coroutines.flow.Flow

interface VehicleSource {
    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}