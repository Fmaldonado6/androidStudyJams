package com.fmaldonado.listaanimes.dataSources

import com.fmaldonado.listaanimes.models.AnimeResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeDataSource {
    @GET("top/anime/{page}")
    suspend fun getAnimeList(@Path("page") page: Int): AnimeResponse
}