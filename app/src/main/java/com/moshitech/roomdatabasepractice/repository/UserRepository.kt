package com.moshitech.roomdatabasepractice.repository

import androidx.lifecycle.LiveData
import com.moshitech.roomdatabasepractice.data.UserDao
import com.moshitech.roomdatabasepractice.model.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }
}