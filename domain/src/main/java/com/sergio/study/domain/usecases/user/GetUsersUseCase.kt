package com.sergio.study.domain.usecases.user

import com.sergio.study.domain.models.User

interface GetUsersUseCase {
    suspend operator fun invoke(): List<User>
}