package com.example.rickandmorty.domain.models

import com.example.rickandmorty.base.IBaseDiffModel

data class RickAndMortyLocation(
    override val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: ArrayList<String>,
    val url: String,
    val created: String
) : IBaseDiffModel
