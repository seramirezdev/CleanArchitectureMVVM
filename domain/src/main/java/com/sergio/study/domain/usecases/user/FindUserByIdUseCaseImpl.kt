package com.sergio.study.domain.usecases.user

import com.sergio.study.domain.models.User
import com.sergio.study.domain.repositories.UserRepository

class FindUserByIdUseCaseImpl(private val userRepository: UserRepository) :
    FindUserByIdUseCase {
    override suspend operator fun invoke(userId: Int): User = userRepository.getUserById(userId)
}