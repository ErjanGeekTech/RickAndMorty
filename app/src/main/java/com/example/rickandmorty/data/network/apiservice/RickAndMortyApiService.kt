package com.example.rickandmorty.data.network.apiservice

import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {
    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<RickAndMortyCharacters>>
}