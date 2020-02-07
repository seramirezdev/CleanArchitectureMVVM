package com.sergio.study.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sergio.study.data.database.dao.UserDao
import com.sergio.study.data.database.entities.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class LocalDB : RoomDatabase() {

    abstract fun userDao(): UserDao
}