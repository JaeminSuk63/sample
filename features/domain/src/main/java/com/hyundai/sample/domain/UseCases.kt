package com.hyundai.sample.domain

import com.hyundai.sample.domain.useCases.AddSearchHistory
import com.hyundai.sample.domain.useCases.DeleteSearchHistory
import com.hyundai.sample.domain.useCases.GetApiVersion
import com.hyundai.sample.domain.useCases.GetIgnitionState
import com.hyundai.sample.domain.useCases.GetSearchHistory
import com.hyundai.sample.domain.useCases.IsParkingBrakeOn

data class UseCases(
    val addSearchHistory: AddSearchHistory,
    val deleteSearchHistory: DeleteSearchHistory,
    val getApiVersion: GetApiVersion,
    val getIgnitionState: GetIgnitionState,
    val getSearchHistory: GetSearchHistory,
    val isParkingBrakeOn: IsParkingBrakeOn,
)
