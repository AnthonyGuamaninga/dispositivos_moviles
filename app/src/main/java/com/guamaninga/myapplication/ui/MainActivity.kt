package com.guamaninga.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.creative.ipfyandroid.Ipfy
import com.creative.ipfyandroid.IpfyClass
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var login = Login()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Ipfy.init(this) // this is a context of application
        //or you can also pass IpfyClass type to get either IPv4 address only or universal address IPv4/v6 as
        Ipfy.init(this, IpfyClass.IPv4) //to get only IPv4 address
        //and
        Ipfy.init(this, IpfyClass.UniversalIP) //to get Universal address in IPv4/v6

        getIpAddress()
    }

    override fun onStart() {
        super.onStart()
        startControl()
        getAndShowUserInformation()
    }
    fun getAndShowUserInformation(){
        binding.txtTitleMain.text = getString(R.string.txt_welcome, intent.getStringExtra("user") )
        binding.txtMisNombres.text = intent.getStringExtra("name")
        binding.txtMiApellido.text = intent.getStringExtra("lastName")

    }
    fun startControl(){ //para el boton regresar
        binding.btnRegresar.setOnClickListener{
            onBackPressed()
        }
    }
    private fun getIpAddress(){
        Ipfy.getInstance().getPublicIpObserver().observe(this, { ipData ->
            binding.txtIp.text = ipData.currentIpAddress // this is a value which is your current public IP address, null if no/lost internet connection

        })
    }
}