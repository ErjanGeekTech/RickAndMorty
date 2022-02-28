package com.example.rickandmorty.data.remote.dtos

import com.example.rickandmorty.domain.models.RickAndMortyEpisode
import com.google.gson.annotations.SerializedName

data class RickAndMortyEpisodeDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val air_date: String,

    @SerializedName("episode")
    val episode: String,

    @SerializedName("characters")
    val characters: ArrayList<String>,

    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
)

fun RickAndMortyEpisodeDto.toEpisode() =
    RickAndMortyEpisode(id, name, air_date, episode, characters, url, created)