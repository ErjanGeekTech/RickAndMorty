package com.example.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName
@Entity
data class RickAndMortyEpisodes(
    @PrimaryKey
    @SerializedName("id")
    override var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("air_date")
    val airDate: String,

    @SerializedName("episode")
    val episode: String,


    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
): IBaseDiffModel