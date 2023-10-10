package com.example.kotlin.newapp.data.model

import com.example.kotlin.newapp.data.movie.BaseMovie
import com.google.gson.annotations.SerializedName

data class MovieObject (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: ArrayList<BaseMovie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
)


