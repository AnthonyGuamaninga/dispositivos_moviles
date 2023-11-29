package com.guamaninga.myapplication.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.guamaninga.myapplication.data.entities.Users

@Dao
interface UsersDAO {
    @Query("select * from Users")
    fun getAllUsers(): List<Users>

    @Query("select * from Users where id= :userId")
    fun getUserId(userId:Int) : Users

    @Insert
    fun insertUser(lstUsers: List<Users>)

    @Update
    fun updateUsers(lstUsers: List<Users>)

    @Delete
    fun deleteUser(user:Users)

}