package com.guamaninga.myapplication.logic

import com.guamaninga.myapplication.data.entities.Users
import com.guamaninga.myapplication.data.repository.DBRepository
import com.guamaninga.myapplication.data.repository.UserRepository

class LoginUseCase(val connection: DBRepository) {

    fun checkUserandPassword(user:String, password:String): Int{
        var ret = -1
        var users= UserRepository().getListUsers()
        val exist = users.filter {
            it.password==password && it.userName==user
        }
        if( exist.isNotEmpty()){
            ret = exist.first().userId
        }
        return ret
    }

    fun getUserName1(userId: Int):Users=
        connection.getUsersDAO().getOneUser(userId)


    fun getUserNAme(usrId:Int) : Users=
        UserRepository().getListUsers().first{
            it.userId == usrId
        }

    fun insertUser()=
        if(connection.getUsersDAO().getAllUsers().isNotEmpty()){
            connection.getUsersDAO().insertUser(
                UserRepository().getListUsers()
            )
        }else{

        }

}