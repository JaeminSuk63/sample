package com.hyundai.sample.core.data.dataSources

interface RemoteSource {
    suspend fun getApiVersion(): Int?
}