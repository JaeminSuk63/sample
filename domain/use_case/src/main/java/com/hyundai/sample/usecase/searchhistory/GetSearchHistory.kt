package com.hyundai.sample.usecase.searchhistory

import com.hyundai.sample.usecase.SampleRepository

class GetSearchHistory(private val repository: SampleRepository) {
    operator fun invoke() = repository.getSearchHistory()
}