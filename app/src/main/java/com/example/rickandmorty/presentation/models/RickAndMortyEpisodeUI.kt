package com.example.rickandmorty.presentation.models

import com.example.rickandmorty.IBaseDiffModel
import com.example.rickandmorty.domain.models.RickAndMortyEpisode

data class RickAndMortyEpisodeUI(
    override val id: Int,
    val name: String,
    val air_date: String,
    val episode: String,
    val characters: ArrayList<String>,
    val url: String,
    val created: String
) : IBaseDiffModel

fun RickAndMortyEpisode.toEpisodeUI() =
    RickAndMortyEpisodeUI(id, name, air_date, episode, characters, url, created)