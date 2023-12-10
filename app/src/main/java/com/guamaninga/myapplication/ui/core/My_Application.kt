package com.guamaninga.myapplication.ui.core

import android.app.Application
import com.guamaninga.myapplication.data.repository.DBConnection
import com.guamaninga.myapplication.data.repository.DBRepository
import com.guamaninga.myapplication.logic.LoginUseCase

class My_Application: Application() {
    override fun onCreate() {
        super.onCreate()
        //con = DBConnection().getConnection(applicationContext)
        //LoginUseCase(con).insertUser()
    }

    companion object{
        private lateinit var con: DBRepository

        fun getConnectionDB():DBRepository?{
            return con
        }
    }
}