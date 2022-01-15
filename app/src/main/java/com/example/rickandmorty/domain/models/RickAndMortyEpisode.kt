package com.example.rickandmorty.domain.models

import com.example.rickandmorty.base.IBaseDiffModel

data class RickAndMortyEpisode(
    override val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: ArrayList<String>,
    val url: String,
    val created: String
) : IBaseDiffModel