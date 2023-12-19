package com.hyundai.sample.base.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.entity.SearchHistoryItem
import com.hyundai.sample.usecase.SampleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: SampleUseCase,
) : ViewModel() {

    private val _searchHistoryList: MutableStateFlow<List<SearchHistoryItem>> =
        MutableStateFlow(emptyList())
    val searchHistoryList: StateFlow<List<SearchHistoryItem>> =
        _searchHistoryList

    init {
        getSearchHistoryList()
    }

    fun addSearchHistory(item: SearchHistoryItem) =
        viewModelScope.launch {
            useCase.addSearchHistory(item)
        }

    fun deleteSearchHistory(item: SearchHistoryItem) =
        viewModelScope.launch {
            useCase.deleteSearchHistory(item)
        }

    private fun getSearchHistoryList() = viewModelScope.launch {
        useCase.getSearchHistory().collect {
            _searchHistoryList.value = it
        }
    }
}