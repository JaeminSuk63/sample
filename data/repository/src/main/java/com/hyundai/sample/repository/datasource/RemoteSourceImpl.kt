package com.hyundai.sample.repository.datasource

import com.hyundai.sample.api.Api

class RemoteSourceImpl(private val api: Api) : RemoteSource {
    override suspend fun getApiVersion(): Int? {
        val result = api.fetchApiVersion()
        if (result.isSuccessful) {
            val data = result.body()
            if (data != null) {
                return data.version
            }
        }
        return null
    }
}