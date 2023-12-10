package com.hyundai.sample.api

import com.google.gson.annotations.SerializedName

data class VersionDto(
    @SerializedName("version")
    val version: Int
)
