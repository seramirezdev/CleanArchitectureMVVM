package com.sergio.study.data.datasources.local

import com.sergio.study.data.database.dao.UserDao
import com.sergio.study.data.database.entities.UserEntity
import com.sergio.study.data.mappers.userDaoUserDomain
import com.sergio.study.data.mappers.userDomainToUserDao
import com.sergio.study.domain.models.User
import timber.log.Timber

class UserDataSourceLocalImpl(private val userDao: UserDao) : UserDataSourceLocal {

    override suspend fun insertUsers(users: List<User>) {
        userDao.insertUsers(users.map(::userDomainToUserDao))
    }

    override suspend fun getAll(): List<User> {
        var data = listOf<UserEntity>()
        try {
            data = userDao.loadAll()
        } catch (e: IllegalStateException) {
            Timber.d("No hay datos")
        }

        return data.map(::userDaoUserDomain)
    }

    override suspend fun getUserById(userId: Int): User {
        val user = userDao.findById(userId)
        return userDaoUserDomain(user)
    }
}