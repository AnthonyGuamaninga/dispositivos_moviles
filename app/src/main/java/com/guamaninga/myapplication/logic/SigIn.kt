package com.guamaninga.myapplication.logic

import com.guamaninga.myapplication.data.repository.DBUsers

class SigIn {
    fun checkUserAndPassword(user:String, password:String):Boolean{
        var listUsers =DBUsers().getListUsers()

        for(u in listUsers){
            if(user.equals(u.userName) and password.equals(u.password)){
                return true
            }
        }

        /*if(user.equals("admin") and password.equals("123") ){
            return true
        }*/
        return false
    }
}