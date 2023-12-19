package com.hyundai.sample.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val useCase: SampleUseCase,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow("")
    val errorMessage = _errorMessage.asStateFlow()

    var isStartCondition = true

    init {
        checkStartCondition()
    }

    private fun checkStartCondition() = viewModelScope.launch {
        _errorMessage.value = "CCS"
        isStartCondition = true
        _isLoading.value = false
    }
}