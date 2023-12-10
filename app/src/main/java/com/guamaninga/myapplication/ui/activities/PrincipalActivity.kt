package com.guamaninga.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.databinding.ActivityPrincipalBinding
import com.guamaninga.myapplication.ui.fragments.FavoriteFragment
import com.guamaninga.myapplication.ui.fragments.ListFragment

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listFragment  =ListFragment()
        val favoritesFragment  =FavoriteFragment()

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.it_home -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, listFragment)
                    transaction.commit()
                    true
                }
                R.id.it_fav -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, favoritesFragment)
                    transaction.commit()
                    true
                }
                else -> false
            }
        }

        /*   intent.extras.let {
               My_Application
                   .getConnectionDB()!!
                   .getUsersDAO()
                   .getOneUser(1)

               val userId = it?.getInt(Constants.USRID)
               if(userId != null){
                   val  user = LoginUseCase(My_Application.getConnectionDB()!!)
                       .getUserNAme(userId)
                   binding.txtUsrId.text = "Bienvenido " + user.firstName.toString() + " " + user.lastName.toString()
               }
               else{
                   Snackbar.make(
                       binding.txtUsrId,
                       "Ocurrio un error",
                       Snackbar.LENGTH_SHORT).show()
               }
           }*/
    }
}