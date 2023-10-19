package com.example.kotlin.newapp.data.network

import com.example.kotlin.newapp.data.network.model.MovieObject
import com.example.kotlin.newapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Interfaz para interactuar con la API de TMDB.
 *
 * Esta interfaz define los métodos necesarios para interactuar con la API de TMDB.
 */
interface MovieAPIService {

    /**
     * Obtiene una lista de películas de la API de TMDB.
     *
     * @param language El idioma en el que se devolverán los resultados.
     * @param page El número de página de resultados a devolver.
     * @param accept El tipo de contenido que se acepta en la respuesta.
     * @param authorization La clave de la API.
     * @return Un objeto MovieObject con la lista de películas.
     */
    //https://api.themoviedb.org/3/movie/
    @GET("popular")
    suspend fun getMovieList(
        @Query("language") language:String,
        @Query("page") page:Int,
        @Header("accept") accept:String = "application/json",
        @Header("Authorization") authorization:String = Constants.API_KEY
    ): MovieObject
}