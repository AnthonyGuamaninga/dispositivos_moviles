package com.guamaninga.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.data.entities.Users
import com.guamaninga.myapplication.databinding.UsersItemsBinding

class UsersAdapter(val listUsers: List<Users>) :RecyclerView.Adapter<UsersAdapter.UsersVH>() {

    class UsersVH(view: View): RecyclerView.ViewHolder(view){
        private var binding: UsersItemsBinding = UsersItemsBinding.bind(view)
        fun render(item:Users){
            binding.avatarImg.load("https://cdn-icons-png.flaticon.com/512/10892/10892514.png"){
                placeholder(R.drawable.proyect_yasuo)
                crossfade(true)
            }
            binding.txtId.text = item.userId.toString()
            binding.txtNombre.text = item.userName.toString() +" "+ item.lastName.toString()
            //binding.txtApellido.text = item.lastName.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersVH {
        val inflater = LayoutInflater.from(parent.context)
        return UsersVH(inflater.inflate(R.layout.users_items, parent, false))
    }

    override fun getItemCount(): Int = listUsers.size

    override fun onBindViewHolder(holder: UsersVH, position: Int) {
        holder.render(listUsers[position])
    }
}