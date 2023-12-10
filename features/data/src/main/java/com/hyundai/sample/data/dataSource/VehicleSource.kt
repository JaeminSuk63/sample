package com.hyundai.sample.data.dataSource

import kotlinx.coroutines.flow.Flow

interface VehicleSource {
    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}