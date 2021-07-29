package com.example.rickandmorty.models

import com.google.gson.annotations.SerializedName
import java.util.*

data class RickAndMortyResponse<T>(
    @SerializedName("info")
    private var info: Info,
    @SerializedName("results")
     var results: ArrayList<T>
)