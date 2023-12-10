package com.hyundai.sample.data.api

import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("automation/modes/version")
    suspend fun fetchApiVersion(): Response<VersionDto>
}