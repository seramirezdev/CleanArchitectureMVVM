package com.sergio.study.domain.usecases.user

import com.sergio.study.domain.models.User
import com.sergio.study.domain.repositories.UserRepository

class InsertUsersUseCaseImpl(private val userRepository: UserRepository) :
    InsertUsersUseCase {
    override suspend operator fun invoke(users: List<User>) = userRepository.insertUsers(users)
}