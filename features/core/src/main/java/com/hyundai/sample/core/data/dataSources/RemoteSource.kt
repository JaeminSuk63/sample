package com.hyundai.sample.core.data.dataSources

interface RemoteSource {
    fun getApiVersion(): Int?
}