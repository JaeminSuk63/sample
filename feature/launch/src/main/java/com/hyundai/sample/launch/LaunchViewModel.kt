package com.hyundai.sample.launch

import androidx.lifecycle.ViewModel
import com.hyundai.sample.domain.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        _isLoading.value = isLoading()
    }

    private fun isLoading(): Boolean {
        // Check real start condition with useCases
        return false
    }
}