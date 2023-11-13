package com.hyundai.sample.core.data.api

import com.google.gson.annotations.SerializedName

data class VersionDto(
    @SerializedName("version")
    val version: Int
)
