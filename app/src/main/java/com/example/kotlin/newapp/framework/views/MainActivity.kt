package com.example.kotlin.newapp.framework.views

import android.app.Activity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin.newapp.framework.adapters.AppAdapter
import com.example.kotlin.newapp.databinding.ActivityMainBinding

class MainActivity: Activity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter : AppAdapter = AppAdapter()
    private lateinit var data:ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeBinding()
    }

    private fun initializeBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpRecyclerView(dataForList:ArrayList<String>){
        binding.RVApp.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false)
        binding.RVApp.layoutManager = linearLayoutManager
        adapter.CommonsAdapter(dataForList)
        binding.RVApp.adapter = adapter
    }
}