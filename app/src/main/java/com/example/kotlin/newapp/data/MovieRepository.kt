package com.example.kotlin.newapp.data

import com.example.kotlin.newapp.data.network.MovieApiClient
import com.example.kotlin.newapp.data.network.model.MovieObject

/**
 * Repositorio para interactuar con la API de TMDB.
 *
 * Este objeto proporciona una instancia de MovieApiClient usado para comunicarse con
 * la API de TMDB.
 */
class MovieRepository() {

    private val apiMovie = MovieApiClient()

    /**
     * Obtiene una lista de películas de la API de TMDB.
     *
     * @param language El idioma en el que se devolverán los resultados.
     * @param page El número de página de resultados a devolver.
     * @return Un objeto MovieObject con la lista de películas.
     */
    suspend fun getMovieList(language: String, page: Int): MovieObject? =
        apiMovie.getMovieList(language, page)
}
