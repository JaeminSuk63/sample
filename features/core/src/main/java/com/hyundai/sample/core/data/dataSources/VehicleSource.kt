package com.hyundai.sample.core.data.dataSources

import kotlinx.coroutines.flow.Flow

interface VehicleSource {
    fun getIgnitionState(): Flow<Int?>

    fun isParkingBrakeOn(): Boolean
}