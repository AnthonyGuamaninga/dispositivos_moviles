package com.guamaninga.myapplication.core

import android.app.Application
import com.guamaninga.myapplication.data.repository.DBConnection
import com.guamaninga.myapplication.data.repository.DBRepository
import com.guamaninga.myapplication.logic.SigIn

class My_Application: Application() {
    override fun onCreate() {
        super.onCreate()
        con = DBConnection().getConnection(applicationContext)
        SigIn(con).insertUsers()
    }

    companion object{
        private lateinit var con: DBRepository

        fun getConnectionDB():DBRepository?{
            return con
        }
    }
}