package com.hyundai.sample.base.cloud

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CloudViewModel @Inject constructor(
    private val useCase: SampleUseCase,
) : ViewModel() {
    private val _apiVersion: MutableStateFlow<String?> = MutableStateFlow(null)
    val apiVersion: StateFlow<String?> = _apiVersion

    init {
        getApiVersion()
    }

    private fun getApiVersion() = viewModelScope.launch {
        _apiVersion.value = "Version: " + useCase.getApiVersion().toString()
    }
}