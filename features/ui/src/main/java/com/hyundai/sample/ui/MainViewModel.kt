package com.hyundai.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.core.domain.SearchHistoryItem
import com.hyundai.sample.core.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _ignitionState: MutableStateFlow<String?> = MutableStateFlow(null)
    val ignitionState: StateFlow<String?> = _ignitionState

    private val _parkingBrakeState: MutableStateFlow<String?> = MutableStateFlow(null)
    val parkingBrakeState: StateFlow<String?> = _parkingBrakeState

    private val _apiVersion: MutableStateFlow<String?> = MutableStateFlow(null)
    val apiVersion: StateFlow<String?> = _apiVersion

    private val _searchHistoryList: MutableStateFlow<List<SearchHistoryItem>> =
        MutableStateFlow(emptyList())
    val searchHistoryList: StateFlow<List<SearchHistoryItem>> = _searchHistoryList

    init {
        getIgnitionState()
        getParkingState()
        getApiVersion()
        getSearchHistoryList()
    }

    private fun getSearchHistoryList() = viewModelScope.launch {
        useCases.getSearchHistory().collect {
            _searchHistoryList.value = it
        }
    }

    private fun getApiVersion() {
        TODO("Not yet implemented")
    }

    private fun getParkingState() {
        TODO("Not yet implemented")
    }

    private fun getIgnitionState() {
        TODO("Not yet implemented")
    }


}