package com.guamaninga.myapplication.data.repository

import com.guamaninga.myapplication.data.entities.Users

class DBUsers {

    fun getListUsers(): List<Users>{
        var user1= Users("admin", "123", 1,"Alfred","Guamaninga")
        var user2= Users("Steven", "steven")
        var user3= Users("Cyntia", "cyntia")
        var user4= Users("Carlos", "carlos")

        var lstUsers = listOf(user1,user2,user3,user4)
        return lstUsers
    }
}