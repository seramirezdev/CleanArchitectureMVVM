package com.sergio.study.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sergio.study.data.database.constants.DBUserTable

@Entity(tableName = DBUserTable)
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "email")
    val email: String,
    @Embedded val address: AddressEntity,
    @ColumnInfo(name = "phone")
    val phone: String,
    @ColumnInfo(name = "website")
    val website: String,
    @Embedded val company: CompanyEntity
)

data class AddressEntity(
    @ColumnInfo(name = "street")
    val street: String,
    @ColumnInfo(name = "suite")
    val suite: String,
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "zip_code")
    val zipCode: String,
    @Embedded val geo: GeoEntity
)

data class CompanyEntity(
    @ColumnInfo(name = "name_company")
    val nameCompany: String,
    @ColumnInfo(name = "catch_phrase")
    val catchPhrase: String?,
    @ColumnInfo(name = "bs")
    val bs: String
)

data class GeoEntity(
    @ColumnInfo(name = "lat")
    val lat: String,
    @ColumnInfo(name = "lng")
    val lng: String
)
