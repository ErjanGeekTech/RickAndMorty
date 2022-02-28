package com.example.rickandmorty.data.remote.dtos

import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("count")
    private val count: Int,

    @SerializedName("pages")
    private val pages: Int,

    @SerializedName("next")
    val next: String,

    @SerializedName("prev")
    private val prev: Any
)
