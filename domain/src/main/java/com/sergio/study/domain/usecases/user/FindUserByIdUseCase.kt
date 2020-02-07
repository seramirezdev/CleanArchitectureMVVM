package com.sergio.study.domain.usecases.user

import com.sergio.study.domain.models.User

interface FindUserByIdUseCase {
    suspend operator fun invoke(userId: Int): User
}