package com.example.rickandmorty.domain.models

data class RickAndMortyEpisode(
    val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: ArrayList<String>,
    val url: String,
    val created: String
)