package com.example.kotlin.newapp.domain

import com.example.kotlin.newapp.data.MovieRepository
import com.example.kotlin.newapp.data.network.model.MovieObject

/**
 * Requerimiento de la lista de peliculas
 *
 * Esta clase es usada para obtener la lista de peliculas
 */
class MovieListRequirement {
    private val repository = MovieRepository()

    /**
     * Obtiene la lista de peliculas
     *
     * @param language idioma de la lista de peliculas
     * @param page pagina de la lista de peliculas
     * @return lista de peliculas
     */
    suspend operator fun invoke(
        language:String,
        page:Int
    ): MovieObject? = repository.getMovieList(language, page)
}