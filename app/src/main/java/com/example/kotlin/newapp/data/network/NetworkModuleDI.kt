package com.example.kotlin.newapp.data.network

import com.example.kotlin.newapp.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Modelo de red para interactuar con la API de TMDB.
 *
 * Este objeto proporciona una instancia de MovieAPIService usado para comunicarse con
 * la API de TMDB.
 */
object NetworkModuleDI {
    private val gsonFactory:GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    /**
     * Crea una instancia de MovieAPIService configurada para interactuar con la API de TMDB.
     *
     * @return Una instancia de MovieAPIService para realizar llamadas a la API.
     */
    operator fun invoke(): MovieAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(MovieAPIService::class.java)
    }

}