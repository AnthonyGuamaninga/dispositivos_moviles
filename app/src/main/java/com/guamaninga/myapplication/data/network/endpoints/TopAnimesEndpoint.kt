package com.guamaninga.myapplication.data.network.endpoints

import com.guamaninga.myapplication.data.network.entities.jikan.top.TopAnimes
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimesEndpoint {

    @GET("v4/top/anime")
    fun getAllTopAnimes(): Response<List<TopAnimes>>
}