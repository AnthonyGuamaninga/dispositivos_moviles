package com.guamaninga.myapplication.logic

import android.content.Context
import com.guamaninga.myapplication.data.entities.Users
import com.guamaninga.myapplication.data.repository.DBConnection
import com.guamaninga.myapplication.data.repository.DBRepository
import com.guamaninga.myapplication.data.repository.DBUsers

class SigIn (val connection: DBRepository){

    var context: Context? = null
    lateinit var context1: Context
    fun checkUserAndPassword(user:String, password:String):Boolean =
        DBUsers().getListUsers().filter { it.userName== user && it.password==password }.isNotEmpty()

    fun checkLogin(userName:String, password: String):Int{
        var ret = -1
        val users = DBUsers().getListUsers()
        val listUsers = users.filter {
            it.password == password && it.userName == userName
        }
        if (listUsers.isNotEmpty()){
            ret = listUsers.first().id
        }
        return ret
    }
    fun getUser(user: String): Users = DBUsers().getListUsers().filter { it.userName== user }.first()

    fun getUserName1(userId:Int): Users=
        connection.getUsersDAO().getOneUser(userId)
    fun getUserName(userId: Int): Users =
        DBUsers().getListUsers().first{it.id == userId}

    fun insertUsers() =
        if(connection.getUsersDAO().getAllUsers().isEmpty()){
            connection.getUsersDAO().insert(DBUsers().getListUsers())
        }else{
        }



}