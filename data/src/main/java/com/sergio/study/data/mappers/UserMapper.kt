package com.sergio.study.data.mappers

import com.sergio.study.data.database.entities.UserEntity
import com.sergio.study.data.dtos.UserDTO
import com.sergio.study.domain.models.User

fun userDtoToUserDomain(userDTO: UserDTO): User =
    User(
        id = userDTO.id.toString(),
        address = addressDtoToAddressDomain(userDTO.address),
        name = userDTO.name,
        company = companyDtoToCompanyDomain(userDTO.company),
        email = userDTO.email,
        phone = userDTO.phone,
        username = userDTO.username,
        website = userDTO.website
    )


fun userDaoUserDomain(userEntity: UserEntity): User =
    User(
        id = userEntity.id,
        address = addressDaoToAddressDomain(userEntity.address),
        name = userEntity.name,
        company = companyDaoToCompanyDomain(userEntity.company),
        email = userEntity.email,
        phone = userEntity.phone,
        username = userEntity.username,
        website = userEntity.website
    )


fun userDomainToUserDao(user: User): UserEntity = UserEntity(
    id = user.id,
    website = user.website,
    username = user.username,
    phone = user.phone,
    email = user.email,
    company = companyDomainToCompanyDao(user.company),
    name = user.name,
    address = addressDomainToAddressDao(user.address)
)