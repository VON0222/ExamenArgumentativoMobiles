package com.example.kotlin.newapp.framework.adapters.viewholders

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.kotlin.newapp.data.network.model.BaseMovie
import com.example.kotlin.newapp.databinding.ItemMovieBinding
import com.example.kotlin.newapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BaseMovie, context:Context){
        binding.TVName.text = item.title
        binding.TVSinapsis.text = item.overview
        getMovieInfo(item.poster_path,binding.IVPhoto,context)
    }

    private fun getMovieInfo(posterPath:String, imageView:ImageView,context:Context) {
            CoroutineScope(Dispatchers.Main).launch {
                val urlImage = Constants.IMAGE_URL + posterPath

                val requestOptions = RequestOptions()
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .fitCenter()
                    .priority(Priority.HIGH)

                Glide.with(context).load(urlImage)
                    .apply(requestOptions)
                    .into(imageView)
            }
    }
}