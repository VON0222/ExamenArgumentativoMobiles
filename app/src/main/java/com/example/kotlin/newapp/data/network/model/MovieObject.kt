package com.example.kotlin.newapp.data.network.model

import com.example.kotlin.newapp.data.movie.BaseMovie
import com.google.gson.annotations.SerializedName

data class MovieObject (
    @SerializedName("page") val page: Int,
    @SerializedName("results") val info: ArrayList<BaseMovie>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int,
)


