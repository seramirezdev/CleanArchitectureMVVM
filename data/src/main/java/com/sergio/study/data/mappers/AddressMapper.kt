package com.sergio.study.data.mappers

import com.sergio.study.data.database.entities.AddressEntity
import com.sergio.study.data.dtos.AddressDTO
import com.sergio.study.domain.models.Address

fun addressDtoToAddressDomain(addressDTO: AddressDTO): Address =
    Address(
        street = addressDTO.street,
        city = addressDTO.city,
        geo = geoDtoToGeoDomain(addressDTO.geo),
        suite = addressDTO.suite,
        zipCode = addressDTO.zipCode
    )

fun addressDaoToAddressDomain(addressEntity: AddressEntity): Address =
    Address(
        street = addressEntity.street,
        zipCode = addressEntity.zipCode,
        suite = addressEntity.suite,
        geo = geoDaoToGeoDomain(addressEntity.geo),
        city = addressEntity.city
    )

fun addressDomainToAddressDao(address: Address): AddressEntity = AddressEntity(
    street = address.street,
    city = address.city,
    geo = geoDomainToGeoDao(address.geo),
    suite = address.suite,
    zipCode = address.zipCode
)
