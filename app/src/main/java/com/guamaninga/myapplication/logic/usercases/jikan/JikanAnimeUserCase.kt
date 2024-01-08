package com.guamaninga.myapplication.logic.usercases.jikan

import android.util.Log
import com.guamaninga.myapplication.data.network.endpoints.AnimeEndPoint
import com.guamaninga.myapplication.data.network.repository.RetrofitBase
import com.guamaninga.myapplication.logic.usercases.jikan.entities.FullInfoAnimeLG
import com.guamaninga.myapplication.ui.core.Constants
import com.guamaninga.myapplication.ui.core.getFullInfoAnimeLG

class JikanAnimeUserCase {
    fun getFullAnimeInfo(nameAnime:Int): FullInfoAnimeLG{
        val baseService = RetrofitBase.getRetrofitJikanConnection()
        val service = baseService.create(AnimeEndPoint::class.java)
        val call = service.getAnimeFullInfo(nameAnime)

        var infoAnime = FullInfoAnimeLG()
        if(call.isSuccessful){
            val a = call.body()!!
            infoAnime = a.getFullInfoAnimeLG()

        }else{
            Log.d(Constants.TEXT_ID, "Error en el llamado del API Jikan")
        }
        return infoAnime

    }

}