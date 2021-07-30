package com.example.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class RickAndMortyEpisodes(
    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("air_date")
    var airDate: String,

    @SerializedName("episode")
    var episode: String,


    @SerializedName("url")
    var url: String,

    @SerializedName("created")
    var created: String
)
