package com.hyundai.sample.repository.datasource

interface RemoteSource {
    suspend fun getApiVersion(): Int?
}