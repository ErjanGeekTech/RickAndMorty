package com.example.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyCharacters(
    @PrimaryKey
    @SerializedName("id")
    override var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String,

    @SerializedName("image")
    val image: String
) : IBaseDiffModel
