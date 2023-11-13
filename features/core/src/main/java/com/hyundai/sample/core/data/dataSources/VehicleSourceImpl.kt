package com.hyundai.sample.core.data.dataSources

import kotlinx.coroutines.flow.Flow

class VehicleSourceImpl : VehicleSource {
    override fun getIgnitionState(): Flow<Int?> {
        TODO("Not yet implemented")
    }

    override fun isParkingBrakeOn(): Boolean {
        TODO("Not yet implemented")
    }
}