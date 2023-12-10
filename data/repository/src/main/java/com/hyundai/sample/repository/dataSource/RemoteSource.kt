package com.hyundai.sample.repository.dataSource

interface RemoteSource {
    suspend fun getApiVersion(): Int?
}