package com.example.kotlin.newapp.data.network

import com.example.kotlin.newapp.data.network.model.MovieObject
import com.example.kotlin.newapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieAPIService {

    //https://api.themoviedb.org/3/movie/
    @GET("popular")
    suspend fun getMovieList(
        @Query("language") language:String,
        @Query("page") page:Int,
        @Header("accept") accept:String = "application/json",
        @Header("Authorization") authorization:String = Constants.API_KEY
    ): MovieObject
}