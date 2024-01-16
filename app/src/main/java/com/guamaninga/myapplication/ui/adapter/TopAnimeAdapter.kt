package com.guamaninga.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.guamaninga.myapplication.R
import com.guamaninga.myapplication.data.network.entities.jikan.top.Data
import com.guamaninga.myapplication.data.network.entities.jikan.top.TopAnime
import com.guamaninga.myapplication.databinding.AnimeItemsBinding
import com.guamaninga.myapplication.databinding.UsersItemsBinding

class TopAnimeAdapter (val listTopAnime: List<Data>) : RecyclerView.Adapter<TopAnimeAdapter.TopAnimeVH>() {

    class TopAnimeVH(view: View): RecyclerView.ViewHolder(view){
        private var binding: AnimeItemsBinding = AnimeItemsBinding.bind(view)
        fun render(item: Data) {
            binding.avatarImg.load(item.images.jpg.large_image_url)
            binding.txtId.text = item.title_english
            binding.txtNombre.text = item.synopsis

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopAnimeVH {
        val inflater = LayoutInflater.from(parent.context)
        return TopAnimeVH(inflater.inflate(R.layout.anime_items, parent, false))
    }

    override fun getItemCount(): Int = listTopAnime.size

    override fun onBindViewHolder(holder: TopAnimeVH, position: Int) {
        holder.render(listTopAnime[position])
    }
}