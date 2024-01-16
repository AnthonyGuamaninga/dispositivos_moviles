package com.guamaninga.myapplication.data.network.endpoints

import com.guamaninga.myapplication.data.network.entities.jikan.top.TopAnime
import retrofit2.Response
import retrofit2.http.GET

interface TopAnimesEndpoint {

    @GET("top/anime")
    suspend fun getAllTopAnimes(): Response<TopAnime>
}