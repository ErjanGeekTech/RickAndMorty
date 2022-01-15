package com.example.rickandmorty.domain.models

import com.example.rickandmorty.base.IBaseDiffModel

data class RickAndMortyCharacter(
    override val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: CharacterLocation,
    val image: String,
    val episode: ArrayList<String>,
    val url: String,
    val created: String,
    var firstEpisode: String?
): IBaseDiffModel

data class Origin(
    val name: String,
    val url: String
)

data class CharacterLocation(
    val name: String,
    val url: String
)
