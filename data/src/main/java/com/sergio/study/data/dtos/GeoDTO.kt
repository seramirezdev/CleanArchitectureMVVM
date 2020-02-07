package com.sergio.study.data.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoDTO(
    val lat: String,
    val lng: String
)
