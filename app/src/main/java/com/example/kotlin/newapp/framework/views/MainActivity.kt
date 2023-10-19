package com.example.kotlin.newapp.framework.views

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.newapp.data.movie.BaseMovie
import com.example.kotlin.newapp.data.network.model.MovieObject
import com.example.kotlin.newapp.data.repository.MovieRepository
import com.example.kotlin.newapp.framework.adapters.MovieAdapter
import com.example.kotlin.newapp.databinding.ActivityMainBinding
import com.example.kotlin.newapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter()
    private lateinit var data:ArrayList<BaseMovie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        getMovieList()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList:ArrayList<BaseMovie>){
        binding.RVMovie.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVMovie.layoutManager = linearLayoutManager
        adapter.MovieAdapter(dataForList,this)
        binding.RVMovie.adapter = adapter
    }

    private fun getMovieList(){
        CoroutineScope(Dispatchers.IO).launch {
            val movieRepository = MovieRepository()
            val result: MovieObject? = movieRepository.getMovieList(Constants.language, 1)
            Log.d("Salida", result?.info.toString())
            CoroutineScope(Dispatchers.Main).launch {
                setUpRecyclerView(result?.info!!)
            }
        }
    }

}