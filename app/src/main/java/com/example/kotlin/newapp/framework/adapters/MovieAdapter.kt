package com.example.kotlin.newapp.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.newapp.framework.adapters.viewholders.MovieViewHolder
import com.example.kotlin.newapp.data.network.model.BaseMovie
import com.example.kotlin.newapp.databinding.ItemMovieBinding


/**
 * Esta clase es usada para almacenar los datos de la pelicula y
 * crear la vista de la tarjeta de la pelicula.
 */
class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    var data:ArrayList<BaseMovie> = ArrayList()
    lateinit var context: Context

    /**
     * Esta funcion es usada para almacenar los datos de la pelicula
     */
    fun MovieAdapter(basicData : ArrayList<BaseMovie>, context:Context){
        this.data = basicData
        this.context = context
    }

    /**
     * Esta funcion es usada para cargar los datos de las tarjetas de peliculas
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }

    /**
     * Esta funcion es usada para crear la vista de la tarjeta de la pelicula
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    /**
     * Esta funcion es usada para obtener el numero de peliculas
     */
    override fun getItemCount(): Int {
        return data.size
    }
}