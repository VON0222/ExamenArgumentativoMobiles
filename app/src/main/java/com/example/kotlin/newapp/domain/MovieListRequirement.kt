package com.example.kotlin.newapp.domain

import com.example.kotlin.newapp.data.MovieRepository
import com.example.kotlin.newapp.data.network.model.MovieObject

class MovieListRequirement {
    private val repository = MovieRepository()

    suspend operator fun invoke(
        language:String,
        page:Int
    ): MovieObject? = repository.getMovieList(language, page)
}