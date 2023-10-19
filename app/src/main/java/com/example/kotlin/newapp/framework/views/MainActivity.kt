package com.example.kotlin.newapp.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.newapp.data.network.model.BaseMovie
import com.example.kotlin.newapp.framework.adapters.MovieAdapter
import com.example.kotlin.newapp.databinding.ActivityMainBinding
import com.example.kotlin.newapp.framework.viewmodel.MainViewModel

class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter()
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getMovieList()
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

    private fun initializeObservers(){
        viewModel.movieObjectLiveData.observe(this){ movieObject ->
            setUpRecyclerView(movieObject.info)
        }
    }

}