package com.guamaninga.myapplication.logic

import com.guamaninga.myapplication.data.entities.Users
import com.guamaninga.myapplication.data.repository.DBUsers

class SigIn {
    fun checkUserAndPassword(user:String, password:String):Boolean =
        DBUsers().getListUsers().filter { it.userName== user && it.password==password }.isNotEmpty()

    fun getUser(user: String): Users = DBUsers().getListUsers().filter { it.userName== user }.first()
}