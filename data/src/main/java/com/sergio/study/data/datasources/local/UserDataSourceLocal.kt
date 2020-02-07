package com.sergio.study.data.datasources.local

import com.sergio.study.data.datasources.UserDataSource
import com.sergio.study.domain.models.User

interface UserDataSourceLocal : UserDataSource {
    suspend fun insertUsers(users: List<User>)
}