package com.example.rickandmorty.domain.models

data class RickAndMortyLocation(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: ArrayList<String>,
    val url: String,
    val created: String
)
