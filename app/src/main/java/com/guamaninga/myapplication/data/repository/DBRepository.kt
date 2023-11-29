package com.guamaninga.myapplication.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.guamaninga.myapplication.data.dao.UsersDAO
import com.guamaninga.myapplication.data.entities.Users

@Database(
    entities = [Users::class],
    version = 1
)
abstract class DBRepository :RoomDatabase(){
    abstract fun getUsersDAO() : UsersDAO
}