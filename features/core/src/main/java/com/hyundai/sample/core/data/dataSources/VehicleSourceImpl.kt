package com.hyundai.sample.core.data.dataSources

import android.car.Car
import android.car.VehicleAreaSeat
import android.car.VehiclePropertyIds
import android.car.hardware.property.CarPropertyManager
import android.content.Context
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class VehicleSourceImpl(context: Context) : VehicleSource {

    private val carPropertyManager =
        Car.createCar(context).getCarManager(Car.PROPERTY_SERVICE) as CarPropertyManager

    private var ignitionState = -1


    override fun getIgnitionState(): Flow<Int?> = flow {
        while (true) {
            val state = carPropertyManager.getIntProperty(
                VehiclePropertyIds.IGNITION_STATE,
                VehicleAreaSeat.SEAT_ROW_1_CENTER
            )
            if (ignitionState != state) {
                emit(state)
            }
            ignitionState = state
            delay(1000)
        }
    }

    override fun isParkingBrakeOn(): Boolean {
        return carPropertyManager.getBooleanProperty(
            VehiclePropertyIds.PARKING_BRAKE_ON,
            VehicleAreaSeat.SEAT_ROW_1_CENTER
        )
    }
}