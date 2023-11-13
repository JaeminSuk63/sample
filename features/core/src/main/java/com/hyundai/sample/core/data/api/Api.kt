package com.hyundai.sample.core.data.api

import retrofit2.Response
import retrofit2.http.GET

interface Api {

    @GET("automation/modes/version")
    fun fetchApiVersion(): Response<VersionDto>
}