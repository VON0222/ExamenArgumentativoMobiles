package com.example.kotlin.newapp.framework.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.mypokedexapp.MovieViewHolder
import com.example.kotlin.newapp.data.movie.BaseMovie
import com.example.kotlin.newapp.databinding.ItemMovieBinding

class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    var data:ArrayList<BaseMovie> = ArrayList()

    fun MovieAdapter(basicData : ArrayList<BaseMovie>){
        this.data = basicData
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}