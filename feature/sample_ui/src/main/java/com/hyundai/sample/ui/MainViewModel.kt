package com.hyundai.sample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hyundai.sample.domain.UseCases
import com.hyundai.sample.entity.SearchHistoryItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: UseCases,
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
}