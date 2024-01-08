package com.guamaninga.myapplication.ui.core

import com.guamaninga.myapplication.data.network.entities.jikan.anime.FullInfoAnime
import com.guamaninga.myapplication.logic.usercases.jikan.entities.FullInfoAnimeLG

fun FullInfoAnime.getFullInfoAnimeLG() = FullInfoAnimeLG(
    this.data.mal_id,
    this.data.title_english,
    this.data.images.jpg.small_image_url,
    this.data.images.jpg.large_image_url,
    this.data.synopsis
)