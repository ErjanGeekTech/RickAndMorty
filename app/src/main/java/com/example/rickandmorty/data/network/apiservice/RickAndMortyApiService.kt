package com.example.rickandmorty.data.network.apiservice

import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyEpisodes
import com.example.rickandmorty.models.RickAndMortyLocations
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiService {
    @GET("api/character")
    fun fetchCharacters(): Call<RickAndMortyResponse<RickAndMortyCharacters>>

    @GET("api/character/{id}")
    fun character(
        @Path("id") id: Int? = null
    ): Call<RickAndMortyCharacters>

    @GET("api/episode")
    fun fetchEpisodes(): Call<RickAndMortyResponse<RickAndMortyEpisodes>>

    @GET("api/location")
    fun fetchLocations(): Call<RickAndMortyResponse<RickAndMortyLocations>>


}