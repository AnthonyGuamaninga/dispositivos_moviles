package com.guamaninga.myapplication.data.local.repository

import com.guamaninga.myapplication.data.local.entities.Users

class UserRepository {

    fun getListUsers(): List<Users>{
        return listOf<Users>(
            Users("admin", "123", 1,"Alfred","Guamaninga"),
            Users("Steven", "steven",2),
            Users("Cyntia", "cyntia",3),
            Users("Carlos", "carlos",4)
        )

    }
}