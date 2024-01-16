package com.guamaninga.myapplication.logic.usercases.jikan

import android.util.Log
import com.guamaninga.myapplication.data.network.endpoints.TopAnimesEndpoint
import com.guamaninga.myapplication.data.network.entities.jikan.top.TopAnime
import com.guamaninga.myapplication.data.network.repository.RetrofitBase
import com.guamaninga.myapplication.ui.core.Constants

class JikanGetTopAnimesUserCase {

    suspend fun getResponse() : Result<TopAnime> {
        var result: Result<TopAnime>?= null
        var infoAnime = TopAnime()

        try {
            val baseService = RetrofitBase.getRetrofitJikanConnection()
            val service = baseService.create(TopAnimesEndpoint::class.java)
            val call = service.getAllTopAnimes()

            if(call.isSuccessful){
                val a = call.body()!!
                infoAnime = a
                result = Result.success(infoAnime)
            }else{
                Log.e(Constants.TEXT_ID, "Error en el llamado del API Jikan")
                result = Result.failure(Exception("Error en el llamado del API Jikan"))
            }
        }catch (ex:Exception){
            Log.e(Constants.TEXT_ID, ex.stackTraceToString())
            result = Result.failure(Exception(ex))
        }

        return result!!
    }

}