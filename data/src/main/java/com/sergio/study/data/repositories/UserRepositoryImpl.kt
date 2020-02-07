package com.sergio.study.data.repositories

import com.sergio.study.data.datasources.local.UserDataSourceLocal
import com.sergio.study.data.datasources.remote.UserDataSourceRemote
import com.sergio.study.domain.models.User
import com.sergio.study.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val userDataSourceRemote: UserDataSourceRemote,
    private val userDataSourceLocal: UserDataSourceLocal
) : UserRepository {

    override suspend fun getUsers(): List<User> {
        var users = userDataSourceLocal.getAll()
        val size = users.size

        if (size == 0) {
            users = userDataSourceRemote.getAll()
            // userDataSourceLocal.insertUsers(users)
        }

        return users
    }

    override suspend fun getUserById(userId: Int): User {
        return userDataSourceRemote.getUserById(userId)
    }

    override suspend fun insertUsers(users: List<User>) {
        userDataSourceLocal.insertUsers(users)
    }
}