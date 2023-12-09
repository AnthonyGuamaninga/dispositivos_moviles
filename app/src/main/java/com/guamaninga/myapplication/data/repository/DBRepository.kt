package com.guamaninga.myapplication.data.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.guamaninga.myapplication.data.dao.UsersDao
import com.guamaninga.myapplication.data.entities.Users

@Database(
    entities = [Users::class],
    version = 1
)
abstract class DBRepository: RoomDatabase() {
    abstract fun getUsersDAO(): UsersDao
}

class DBConnection(){
    fun getConnection(context:Context):DBRepository =
        Room.databaseBuilder(
            context,
            DBRepository::class.java,
            "DBTest"
        ).build()


}