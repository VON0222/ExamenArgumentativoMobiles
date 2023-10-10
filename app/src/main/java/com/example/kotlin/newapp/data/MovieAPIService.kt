package com.example.kotlin.newapp.data

import com.example.kotlin.newapp.data.model.MovieObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MovieAPIService {

    //https://api.themoviedb.org/3/movie/
    @GET("popular")
    suspend fun getMovieList(
        @Query("language") language:String,
        @Query("page") page:Int,
        @Header("application/json") accept:String,
        @Header("Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmZjhkZDc1NmUzMmI4YWNlZjYyZmQ2YzMwZmQwY2NmOSIsInN1YiI6IjY0ZWI5MzhiZTg5NGE2MDEzYmIxNjNjZiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.6cGDTI8wql15qnVZErrd_6QRNaiRAi74pRD0LfOzVZM") authorization:String
    ): MovieObject
}