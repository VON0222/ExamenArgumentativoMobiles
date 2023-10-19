package com.example.kotlin.newapp.data

import com.example.kotlin.newapp.data.network.MovieAPIService
import com.example.kotlin.newapp.data.network.MovieApiClient
import com.example.kotlin.newapp.data.network.NetworkModuleDI
import com.example.kotlin.newapp.data.network.model.MovieObject

class MovieRepository() {

    private val apiMovie = MovieApiClient()

    suspend fun getMovieList(language: String, page: Int): MovieObject? =
        apiMovie.getMovieList(language, page)
}
