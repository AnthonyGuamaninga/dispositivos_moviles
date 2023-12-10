package com.guamaninga.myapplication.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.creative.ipfyandroid.Ipfy
import com.creative.ipfyandroid.IpfyClass
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var userName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Ipfy.init(this) // this is a context of application
        //or you can also pass IpfyClass type to get either IPv4 address only or universal address IPv4/v6 as
        Ipfy.init(this,IpfyClass.IPv4) //to get only IPv4 address
        //and
        Ipfy.init(this,IpfyClass.UniversalIP) //to get Universal address in IPv4/v6

        getIpAdress()
        getAndShowName()

    }


    private fun getIpAdress(){

        Ipfy.getInstance().getPublicIpObserver().observe(this) { ipData ->
            binding.txtIp.text =
                ipData.currentIpAddress
        }
    }

    override fun onStart() {
        super.onStart()
        initControls()
    }

    @SuppressLint("StringFormatInvalid")
    fun getAndShowName(){
        val intent = getIntent()
        binding.txtMisNombres.text =getString(R.string.txt_name, intent.getStringExtra(""))

    }


    fun initControls(){
        binding.btnRegresar.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }



    }

}