package com.sergio.study.data.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyDTO(
    val name: String,
    val catchPhrase: String,
    val bs: String
)