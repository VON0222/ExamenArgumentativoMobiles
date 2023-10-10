package com.example.kotlin.newapp.data

import com.example.kotlin.newapp.data.model.MovieObject
import com.example.kotlin.newapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModuleDI {
    private val gsonFactory:GsonConverterFactory = GsonConverterFactory.create()
    private val okHttpClient: OkHttpClient = OkHttpClient()

    operator fun invoke(): MovieAPIService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(gsonFactory)
            .build()
            .create(MovieAPIService::class.java)
    }

}