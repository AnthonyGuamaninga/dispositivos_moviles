package com.guamaninga.myapplication.logic

class SigIn {
    fun checkUserAndPassword(user:String, password:String):Boolean{
        if(user.equals("admin") and password.equals("123") ){
            return true
        }
        return false
    }
}