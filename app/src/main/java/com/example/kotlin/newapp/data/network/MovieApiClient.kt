package com.example.kotlin.newapp.data.network

import com.example.kotlin.newapp.data.network.model.MovieObject

/**
 * Cliente para realizar operaciones relacionadas con la API de TMBD.
 */
class MovieApiClient {
    private lateinit var api: MovieAPIService

    /**
     * Obtiene una lista de películas de la API de TMDB.
     *
     * @param language El idioma en el que se devolverán los resultados.
     * @param page El número de página de resultados a devolver.
     * @return Un objeto MovieObject con la lista de películas.
     */
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