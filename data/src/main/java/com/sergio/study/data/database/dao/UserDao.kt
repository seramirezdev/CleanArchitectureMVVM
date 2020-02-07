package com.sergio.study.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.sergio.study.data.database.constants.DBUserTable
import com.sergio.study.data.database.entities.UserEntity

@Dao
interface UserDao {

    @Query(value = "SELECT * FROM $DBUserTable")
    suspend fun loadAll(): List<UserEntity>

    @Query(value = "SELECT * FROM $DBUserTable where id = :userId")
    suspend fun findById(userId: Int): UserEntity

    @Insert
    suspend fun insertUsers(users: List<UserEntity>)
}