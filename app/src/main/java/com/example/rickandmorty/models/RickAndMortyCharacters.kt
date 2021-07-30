package com.example.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class RickAndMortyCharacters(
    @PrimaryKey
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("status")
    var status: String,

    @SerializedName("image")
    var image: String
)
