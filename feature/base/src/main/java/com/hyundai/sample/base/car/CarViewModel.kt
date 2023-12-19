package com.hyundai.sample.base.car

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(
    private val useCase: SampleUseCase,
) : ViewModel() {

    private val _ignitionState: MutableStateFlow<String?> = MutableStateFlow(null)
    val ignitionState: StateFlow<String?> = _ignitionState

    private val _parkingBrakeState: MutableStateFlow<String?> = MutableStateFlow(null)
    val parkingBrakeState: StateFlow<String?> = _parkingBrakeState

    init {
        getIgnitionState()
        getParkingState()
    }

    private fun getParkingState() = viewModelScope.launch {
        if (useCase.isParkingBrakeOn()) {
            _parkingBrakeState.value = "Parking brake On"
        } else {
            _parkingBrakeState.value = "Parking brake OFF"
        }
    }

    private fun getIgnitionState() = viewModelScope.launch {
        useCase.getIgnitionState().collect {
            _ignitionState.value = when (it) {
                0 -> "Undefined"
                1 -> "Lock"
                2 -> "IGN Off"
                3 -> "ACC on"
                4 -> "IGN on"
                5 -> "IGN Start"
                else -> ""
            }
        }
    }


}