package com.example.rickandmorty.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.rickandmorty.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

@Entity
data class RickAndMortyLocations(
    @PrimaryKey
    @SerializedName("id")
    override var id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("dimension")
    val dimension: String,


    @SerializedName("url")
    val url: String,

    @SerializedName("created")
    val created: String
): IBaseDiffModel
