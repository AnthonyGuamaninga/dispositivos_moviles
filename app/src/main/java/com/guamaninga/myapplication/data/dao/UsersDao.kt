package com.guamaninga.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.guamaninga.myapplication.data.entities.Users

@Dao
interface UsersDao {

    @Query("select * from Users")
    fun getAllUsers(): List<Users>

    @Query("select * from Users where id=:userId")
    fun getOneUser(userId:Int): Users

    @Insert
    fun insert(users:List<Users>)

    @Update
    fun update(users:List<Users>)

    @Delete
    fun delete(user: Users)
}