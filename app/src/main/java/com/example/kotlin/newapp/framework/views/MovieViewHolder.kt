package com.example.kotlin.mypokedexapp

import android.content.Context
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.newapp.data.movie.BaseMovie
import com.example.kotlin.newapp.databinding.ItemMovieBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BaseMovie){
        binding.TVName.text = item.title
    }

}