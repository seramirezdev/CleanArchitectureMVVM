package com.sergio.study.data.datasources

import com.sergio.study.domain.models.User

interface UserDataSource {

    suspend fun getAll(): List<User>
    suspend fun getUserById(userId: Int): User
}