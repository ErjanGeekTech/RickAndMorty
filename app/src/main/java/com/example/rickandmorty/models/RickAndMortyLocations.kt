package com.example.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyLocations(
    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("type")
    var type: String,

    @SerializedName("dimension")
    var dimension: String,


    @SerializedName("url")
    var url: String,

    @SerializedName("created")
    var created: String
)
