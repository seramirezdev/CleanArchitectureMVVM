package com.sergio.study.data.mappers

import com.sergio.study.data.database.entities.CompanyEntity
import com.sergio.study.data.dtos.CompanyDTO
import com.sergio.study.domain.models.Company

fun companyDtoToCompanyDomain(companyDTO: CompanyDTO): Company =
    Company(
        name = companyDTO.name,
        bs = companyDTO.bs,
        catchPhrase = companyDTO.catchPhrase
    )

fun companyDaoToCompanyDomain(companyEntity: CompanyEntity): Company =
    Company(
        name = companyEntity.nameCompany,
        bs = companyEntity.bs,
        catchPhrase = companyEntity.catchPhrase ?: ""
    )

fun companyDomainToCompanyDao(company: Company): CompanyEntity =
    CompanyEntity(nameCompany = company.name, catchPhrase = company.catchPhrase, bs = company.bs)