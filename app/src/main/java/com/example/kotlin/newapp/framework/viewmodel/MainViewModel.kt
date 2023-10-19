package com.example.kotlin.newapp.framework.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin.newapp.data.network.model.MovieObject
import com.example.kotlin.newapp.data.network.model.MovieRepository
import com.example.kotlin.newapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    val movieObjectLiveData = MutableLiveData<MovieObject>()

    fun getMovieList() {
        viewModelScope.launch(Dispatchers.IO) {
            val movieRepository = MovieRepository()
            val result: MovieObject? = movieRepository.getMovieList(Constants.language, 1)
            CoroutineScope(Dispatchers.Main).launch {
                movieObjectLiveData.postValue(result!!)
            }
        }
    }
}