package com.example.kotlin.newapp.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.newapp.data.network.model.BaseMovie
import com.example.kotlin.newapp.framework.adapters.MovieAdapter
import com.example.kotlin.newapp.databinding.ActivityMainBinding
import com.example.kotlin.newapp.framework.viewmodel.MainViewModel

/**
 * Esta clase es usada para crear la vista principal de la aplicacion
 */
class MainActivity: AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter()
    private val viewModel: MainViewModel by viewModels()

    /**
     * Esta funcion es usada para crear la vista principal de la aplicacion
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        initializeObservers()
        viewModel.getMovieList()
    }

    /**
     * Esta funcion es usada para inicializar el binding
     */
    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    /**
     * Esta funcion es usada para inicializar el recycler view
     */
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

    /**
     * Esta funcion es usada para inicializar los observadores
     */
    private fun initializeObservers(){
        viewModel.movieObjectLiveData.observe(this){ movieObject ->
            setUpRecyclerView(movieObject.info)
        }
    }

}