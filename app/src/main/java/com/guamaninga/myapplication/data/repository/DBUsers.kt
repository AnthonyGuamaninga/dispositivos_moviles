package com.guamaninga.myapplication.data.repository

import com.guamaninga.myapplication.data.entities.Users

class DBUsers {

    fun getListUsers(): List<Users>{
        var user1= Users(1,"admin", "123")
        var user2= Users(1,"Alfred", "alfred")
        var user3= Users(1,"Cyntia", "cyntia")

        var lstUsers = listOf(user1,user2,user3)
        return lstUsers
    }
}