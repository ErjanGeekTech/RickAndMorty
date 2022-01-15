package com.example.rickandmorty.data.remote.dtos

import com.example.rickandmorty.domain.models.CharacterLocation
import com.example.rickandmorty.domain.models.Origin
import com.example.rickandmorty.domain.models.RickAndMortyCharacter
import com.google.gson.annotations.SerializedName

data class RickAndMortyCharacterDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("species")
    val species: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("origin")
    val origin: OriginDto,

    @SerializedName("location")
    val location: CharacterLocationDto,

    @SerializedName("image")
    val image: String,

    @SerializedName("episode")
    val episode: ArrayList<String>,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String,

    var firstEpisode: String?
)

fun RickAndMortyCharacterDto.toCharacter() =
    RickAndMortyCharacter(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin.toOrigin(),
        location.toCharacterLocation(),
        image,
        episode,
        url,
        created,
        firstEpisode
    )

data class OriginDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)

fun OriginDto.toOrigin() = Origin(name, url)

data class CharacterLocationDto(
    @SerializedName("name")
    val name: String,

    @SerializedName("url")
    val url: String
)

fun CharacterLocationDto.toCharacterLocation() = CharacterLocation(name, url)