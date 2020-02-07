package com.sergio.study.data.dtos

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserDTO(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressDTO,
    val phone: String,
    val website: String,
    val company: CompanyDTO
)