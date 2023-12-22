package com.guamaninga.myapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.data.entities.Users
import com.guamaninga.myapplication.databinding.ActivityPrincipalBinding
import com.guamaninga.myapplication.logic.LoginUseCase
import com.guamaninga.myapplication.ui.adapter.UsersAdapter
import com.guamaninga.myapplication.ui.core.Constants
import com.guamaninga.myapplication.ui.core.My_Application
import com.guamaninga.myapplication.ui.fragments.FavoriteFragment
import com.guamaninga.myapplication.ui.fragments.ListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PrincipalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        checkDataBase()

        initRecyclerView()

    }
    private fun initRecyclerView(){
        lifecycleScope.launch{
            val usrs = withContext(Dispatchers.IO){ getUsersList() }
            val adapter: UsersAdapter = UsersAdapter(usrs)
            binding.rvUsers.adapter = adapter
            binding.rvUsers.layoutManager =
                LinearLayoutManager(
                    this@PrincipalActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    suspend private fun getUsersList(): List<Users> =
        LoginUseCase(My_Application.getConnectionDB()!!).getAllUsers()


    private fun checkDataBase(){
        lifecycleScope.launch {
            val usrs = withContext(Dispatchers.IO){
                getUsersList()
            }

        }

    }

    private fun initListeners(){

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            val manager = supportFragmentManager

            when(item.itemId) {
                R.id.it_home -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, ListFragment() )
                    transaction.commit()
                    true
                }
                R.id.it_fav -> {
                    val transaction = manager.beginTransaction()
                    transaction.replace(binding.frmContainer.id, FavoriteFragment())
                    transaction.commit()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun correr(){
        lifecycleScope.launch(Dispatchers.Main) {
            val name = withContext(Dispatchers.IO){
                val a = "Alfred"
                val b = a + "Guamaninga"
                b
            }
            binding.txtUsrName.text = name.toString()
        }
    }

    fun pastCall(){
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