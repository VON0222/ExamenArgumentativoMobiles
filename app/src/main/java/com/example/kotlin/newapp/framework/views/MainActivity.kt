package com.example.kotlin.newapp.framework.views

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.newapp.data.movie.BaseMovie
import com.example.kotlin.newapp.framework.adapters.MovieAdapter
import com.example.kotlin.newapp.databinding.ActivityMainBinding

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : MovieAdapter = MovieAdapter()
    private lateinit var data:ArrayList<BaseMovie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
        setUpRecyclerView(testData())
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
        adapter.CommonsAdapter(dataForList)
        binding.RVMovie.adapter = adapter
    }

    private fun testData():ArrayList<BaseMovie>{
        var result = ArrayList<BaseMovie>()

        result.add(BaseMovie(false,
            "/mRGmNnh6pBAGGp6fMBMwI8iTBUO.jpg", listOf(27, 9648, 53),
            968051,
            "en",
            "The Nun II",
            "In 1956 France, a priest is violently murdered, and Sister Irene begins to investigate. She once again comes face-to-face with a powerful evil.",
            4160.929,
            "/5gzzkR7y3hnY8AD1wXjCnVlHba5.jpg",
            "2023-09-06",
            "The Nun II",
            false,
            7.5,
            776))

        return result
    }
}