package com.moshitech.roomdatabasepractice.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moshitech.roomdatabasepractice.model.User

@Database(entities = [User::class], version=1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {
    abstract fun userDao():UserDao
    companion object{
        @Volatile
        private var INSTANCE: UserDatabase?=null

//        fun getDatabase(context: Context): UserDatabase = INSTANCE ?: synchronized(this){
//            val instance = Room.databaseBuilder(
//                context.applicationContext,
//                UserDatabase ::class.java,
//                "user_database"
//            ).build()
//            INSTANCE = instance
//            instance
//        }
        fun getDatabase(context: Context):UserDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return  instance
            }
        }
    }
}