package com.example.kotlin.newapp.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.newapp.framework.adapters.viewholders.MovieViewHolder
import com.example.kotlin.newapp.data.network.model.BaseMovie
import com.example.kotlin.newapp.databinding.ItemMovieBinding


class MovieAdapter: RecyclerView.Adapter<MovieViewHolder>() {
    var data:ArrayList<BaseMovie> = ArrayList()
    lateinit var context: Context

    fun MovieAdapter(basicData : ArrayList<BaseMovie>, context:Context){
        this.data = basicData
        this.context = context
    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item,context)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return data.size
    }
}