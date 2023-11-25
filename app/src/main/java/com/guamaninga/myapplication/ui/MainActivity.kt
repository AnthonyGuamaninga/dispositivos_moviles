package com.guamaninga.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        startControl()
    }

    fun startControl(){
        binding.btnRegresar.setOnClickListener{
            onBackPressed()
        }
    }
}