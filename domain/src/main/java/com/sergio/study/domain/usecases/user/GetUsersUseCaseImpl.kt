package com.sergio.study.domain.usecases.user

import com.sergio.study.domain.models.User
import com.sergio.study.domain.repositories.UserRepository

class GetUsersUseCaseImpl(private val userRepository: UserRepository) :
    GetUsersUseCase {
    override suspend operator fun invoke(): List<User> = userRepository.getUsers()
}