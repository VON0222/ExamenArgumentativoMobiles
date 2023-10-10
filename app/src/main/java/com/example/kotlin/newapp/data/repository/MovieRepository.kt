package com.example.kotlin.newapp.data.repository

import com.example.kotlin.newapp.data.MovieAPIService
import com.example.kotlin.newapp.data.model.MovieObject
import retrofit2.http.Query

class MovieRepository() {
    private lateinit var api: MovieAPIService

    suspend fun getMovieList(language:String, page:Int): MovieObject?{
        //todo: Inicializar variable api
        return try{
            api.getMovieList(language, page)
        }catch (e:java.lang.Exception){
            e.printStackTrace()
            null
        }

    }
}