package com.example.kotlin.mypokedexapp

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.newapp.data.movie.BaseMovie
import com.example.kotlin.newapp.databinding.ItemMovieBinding

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BaseMovie){
        binding.TVName.text = item.title
    }
}