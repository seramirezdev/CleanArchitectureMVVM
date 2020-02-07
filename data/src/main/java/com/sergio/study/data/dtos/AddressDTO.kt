package com.sergio.study.data.dtos

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddressDTO(
    val street: String,
    val suite: String,
    val city: String,
    @Json(name = "zipcode") val zipCode: String,
    val geo: GeoDTO
)