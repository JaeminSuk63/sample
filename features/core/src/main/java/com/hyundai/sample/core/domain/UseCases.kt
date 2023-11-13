package com.hyundai.sample.core.domain

import com.hyundai.sample.core.domain.useCases.AddSearchHistory
import com.hyundai.sample.core.domain.useCases.DeleteSearchHistory
import com.hyundai.sample.core.domain.useCases.GetApiVersion
import com.hyundai.sample.core.domain.useCases.GetIgnitionState
import com.hyundai.sample.core.domain.useCases.GetSearchHistory
import com.hyundai.sample.core.domain.useCases.IsParkingBrakeOn

data class UseCases(
    val addSearchHistory: AddSearchHistory,
    val deleteSearchHistory: DeleteSearchHistory,
    val getApiVersion: GetApiVersion,
    val getIgnitionState: GetIgnitionState,
    val getSearchHistory: GetSearchHistory,
    val isParkingBrakeOn: IsParkingBrakeOn,
)
