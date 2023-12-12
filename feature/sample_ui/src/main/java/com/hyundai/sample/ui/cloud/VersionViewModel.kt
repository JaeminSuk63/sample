package com.hyundai.sample.ui.cloud

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VersionViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {
    private val _apiVersion: MutableStateFlow<String?> = MutableStateFlow(null)
    val apiVersion: StateFlow<String?> = _apiVersion

    init {
        getApiVersion()
    }

    private fun getApiVersion() = viewModelScope.launch {
        _apiVersion.value = "Version: " + useCases.getApiVersion().toString()
    }
}