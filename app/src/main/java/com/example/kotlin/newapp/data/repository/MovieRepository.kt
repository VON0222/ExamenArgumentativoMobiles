package com.example.kotlin.newapp.data.repository

import com.example.kotlin.newapp.data.network.MovieAPIService
import com.example.kotlin.newapp.data.network.NetworkModuleDI
import com.example.kotlin.newapp.data.network.model.MovieObject

class MovieRepository() {
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