package com.fmaldonado.listaanimes.models

import com.squareup.moshi.Json

data class AnimeResponse(
    val top: List<Anime>
)

data class Anime(
    @Json(name = "mal_id")
    val id: Int,
    val title: String,
    @Json(name = "image_url")
    val imageUrl: String
)