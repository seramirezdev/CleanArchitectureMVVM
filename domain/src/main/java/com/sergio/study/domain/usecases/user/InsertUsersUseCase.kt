package com.sergio.study.domain.usecases.user

import com.sergio.study.domain.models.User

interface InsertUsersUseCase {
    suspend operator fun invoke(users: List<User>)
}