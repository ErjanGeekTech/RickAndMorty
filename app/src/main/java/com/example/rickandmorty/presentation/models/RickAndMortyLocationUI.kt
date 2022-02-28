package com.example.rickandmorty.presentation.models

import com.example.rickandmorty.IBaseDiffModel
import com.example.rickandmorty.domain.models.RickAndMortyLocation

data class RickAndMortyLocationUI(
    override val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: ArrayList<String>,
    val url: String,
    val created: String
) : IBaseDiffModel

fun RickAndMortyLocation.toLocationUI() =
    RickAndMortyLocationUI(id, name, type, dimension, residents, url, created)