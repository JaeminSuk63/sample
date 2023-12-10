package com.hyundai.sample.data.dataSource

import com.hyundai.sample.data.api.Api

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