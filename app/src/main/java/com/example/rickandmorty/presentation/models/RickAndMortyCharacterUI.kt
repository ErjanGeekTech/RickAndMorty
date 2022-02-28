package com.example.rickandmorty.presentation.models

import com.example.rickandmorty.IBaseDiffModel
import com.example.rickandmorty.domain.models.CharacterLocation
import com.example.rickandmorty.domain.models.Origin
import com.example.rickandmorty.domain.models.RickAndMortyCharacter

data class RickAndMortyCharacterUI(
    override val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginUI,
    val location: CharacterLocationUI,
    val image: String,
    val episode: ArrayList<String>,
    val url: String,
    val created: String,
    var firstEpisode: String?
) : IBaseDiffModel

fun RickAndMortyCharacter.toCharacterUI() =
    RickAndMortyCharacterUI(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.toOriginUI(),
        location.toCharacterLocationUI(),
        image,
        episode,
        url,
        created,
        firstEpisode
    )

data class OriginUI(
    val name: String,
    val url: String
)

fun Origin.toOriginUI() = OriginUI(name, url)

data class CharacterLocationUI(
    val name: String,
    val url: String
)

fun CharacterLocation.toCharacterLocationUI() = CharacterLocationUI(name, url)