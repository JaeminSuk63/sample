package com.hyundai.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.entity.SearchHistoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: com.hyundai.sample.domain.UseCases,
) : ViewModel() {

    private val _ignitionState: MutableStateFlow<String?> = MutableStateFlow(null)
    val ignitionState: StateFlow<String?> = _ignitionState

    private val _parkingBrakeState: MutableStateFlow<String?> = MutableStateFlow(null)
    val parkingBrakeState: StateFlow<String?> = _parkingBrakeState

    private val _apiVersion: MutableStateFlow<String?> = MutableStateFlow(null)
    val apiVersion: StateFlow<String?> = _apiVersion

    private val _searchHistoryList: MutableStateFlow<List<SearchHistoryItem>> =
        MutableStateFlow(emptyList())
    val searchHistoryList: StateFlow<List<SearchHistoryItem>> =
        _searchHistoryList

    init {
        getIgnitionState()
        getParkingState()
        getApiVersion()
        getSearchHistoryList()
    }

    fun addSearchHistory(item: SearchHistoryItem) =
        viewModelScope.launch {
            useCases.addSearchHistory(item)
        }

    fun deleteSearchHistory(item: SearchHistoryItem) =
        viewModelScope.launch {
            useCases.deleteSearchHistory(item)
        }

    private fun getSearchHistoryList() = viewModelScope.launch {
        useCases.getSearchHistory().collect {
            _searchHistoryList.value = it
        }
    }

    private fun getApiVersion() = viewModelScope.launch {
        _apiVersion.value = "Version: " + useCases.getApiVersion().toString()
    }

    private fun getParkingState() = viewModelScope.launch {
        if (useCases.isParkingBrakeOn()) {
            _parkingBrakeState.value = "Parking brake On"
        } else {
            _parkingBrakeState.value = "Parking brake OFF"
        }
    }

    private fun getIgnitionState() = viewModelScope.launch {
        useCases.getIgnitionState().collect {
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