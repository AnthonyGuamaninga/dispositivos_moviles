package com.guamaninga.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.google.android.material.snackbar.Snackbar
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.databinding.ActivityLoginBinding
import com.guamaninga.myapplication.logic.SigIn
import com.guamaninga.myapplication.ui.core.Constants

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val SigIn : SigIn = SigIn()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        startControl()
    }

    fun startControl(){
        binding.btnAccess.setOnClickListener{
            var userName = binding.txtInputUser.text.toString()
            var pass = binding.txtInputPassword.text.toString()



            if(!SigIn.checkUserAndPassword(userName,pass)){
                Snackbar.make(binding.btnAccess,
                    "Error! Usuario o contraseña icorrecta",
                    Snackbar.LENGTH_LONG).show()
            }else{
                val intentExp = Intent(this, MainActivity::class.java)
                intentExp.putExtra(Constants.TEXT_VARIABLE, userName)
                val user = SigIn().getUser(userName)
                intentExp.putExtra(Constants.TEXT_NAME, user.firstName)
                intentExp.putExtra(Constants.TEXT_LASTNAME, user.lastName)
                intentExp.putExtra(Constants.TEXT_ID,  user.id)
                startActivity(intentExp)
            }
        }
    }
}