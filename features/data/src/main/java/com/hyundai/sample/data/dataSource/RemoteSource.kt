package com.hyundai.sample.data.dataSource

interface RemoteSource {
    suspend fun getApiVersion(): Int?
}