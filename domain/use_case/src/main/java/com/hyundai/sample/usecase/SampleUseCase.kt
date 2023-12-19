package com.hyundai.sample.usecase

import com.hyundai.sample.usecase.cloud.GetApiVersion
import com.hyundai.sample.usecase.searchhistory.AddSearchHistory
import com.hyundai.sample.usecase.searchhistory.DeleteSearchHistory
import com.hyundai.sample.usecase.searchhistory.GetSearchHistory
import com.hyundai.sample.usecase.vehicle.GetIgnitionState
import com.hyundai.sample.usecase.vehicle.IsParkingBrakeOn

data class SampleUseCase(
    val addSearchHistory: AddSearchHistory,
    val deleteSearchHistory: DeleteSearchHistory,
    val getApiVersion: GetApiVersion,
    val getIgnitionState: GetIgnitionState,
    val getSearchHistory: GetSearchHistory,
    val isParkingBrakeOn: IsParkingBrakeOn,
)
