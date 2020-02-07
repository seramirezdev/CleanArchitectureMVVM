package com.sergio.study.data.mappers

import com.sergio.study.data.database.entities.GeoEntity
import com.sergio.study.data.dtos.GeoDTO
import com.sergio.study.domain.models.Geo

fun geoDtoToGeoDomain(geoDTO: GeoDTO): Geo =
    Geo(lat = geoDTO.lat, lng = geoDTO.lng)

fun geoDaoToGeoDomain(geoEntity: GeoEntity): Geo =
    Geo(lat = geoEntity.lat, lng = geoEntity.lng)

fun geoDomainToGeoDao(geo: Geo): GeoEntity = GeoEntity(lat = geo.lat, lng = geo.lng)
