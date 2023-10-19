package com.example.kotlin.newapp.data.network

import com.example.kotlin.newapp.data.network.model.MovieObject

class MovieApiClient {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(language:String, page:Int): MovieObject?{
        api = NetworkModuleDI()
        return try{
            api.getMovieList(language, page)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }

    }
}