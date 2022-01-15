package com.example.rickandmorty.data.remote.dtos

import com.example.rickandmorty.domain.models.RickAndMortyLocation
import com.google.gson.annotations.SerializedName

data class RickAndMortyLocationDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("residents")
    val residents: ArrayList<String>,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
)

fun RickAndMortyLocationDto.toLocation() =
    RickAndMortyLocation(id, name, type, dimension, residents, url, created)
