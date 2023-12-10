package com.guamaninga.myapplication.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.guamaninga.myapplication.ui.core.My_Application
import com.guamaninga.myapplication.databinding.ActivityLoginBinding
import com.guamaninga.myapplication.logic.LoginUseCase
import com.guamaninga.myapplication.ui.core.Constants

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initControls()
    }

    fun initControls() {
        binding.btnAccess.setOnClickListener {
            val check = LoginUseCase(
                My_Application.getConnectionDB()!!
            ).checkUserandPassword(
                binding.txtInputUser.text.toString(),
                binding.txtInputPassword.text.toString()
            )

            if (check > 0) {
                val intent = Intent(this, PrincipalActivity::class.java)
                intent.putExtra(Constants.TEXT_ID, check)
                startActivity(intent)
            } else {
                Snackbar.make(
                    binding.btnAccess,
                    "Usuario o contraseña incorrecto",
                    Snackbar.LENGTH_SHORT
                ).show()
                binding.txtInputUser.text?.clear()
                binding.txtInputPassword.text?.clear()
            }
        }

    }
}