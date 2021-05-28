package com.fmaldonado.listaanimes.providers

import com.fmaldonado.listaanimes.dataSources.AnimeDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object AnimeProvider {

    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    val animeService: AnimeDataSource by lazy {
        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://api.jikan.moe/v3/")
            .build().create(AnimeDataSource::class.java)
    }

}