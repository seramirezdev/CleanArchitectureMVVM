package com.sergio.study.domain.repositories

import com.sergio.study.domain.models.User

interface UserRepository {

    suspend fun getUsers(): List<User>
    suspend fun getUserById(userId: Int): User
    suspend fun insertUsers(users: List<User>)
}