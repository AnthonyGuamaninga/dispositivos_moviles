package com.guamaninga.myapplication.ui.core

import android.app.Application
import com.guamaninga.myapplication.data.local.repository.DBConnection
import com.guamaninga.myapplication.data.local.repository.DBRepository
import com.guamaninga.myapplication.logic.usercases.local.LoginUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class My_Application: Application() {
    override fun onCreate() {
        super.onCreate()

        con = DBConnection().getConnection(applicationContext)

        GlobalScope.launch(Dispatchers.IO) {
            LoginUseCase(con).insertUser()
        }

    }

    companion object{
        private lateinit var con: DBRepository

        fun getConnectionDB(): DBRepository?{
            return con
        }
    }
}