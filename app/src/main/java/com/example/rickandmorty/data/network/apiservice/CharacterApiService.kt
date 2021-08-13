package com.example.rickandmorty.data.network.apiservice

import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyEpisodes
import com.example.rickandmorty.models.RickAndMortyLocations
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET ("api/character")
    suspend  fun getListCharacter (
        @Query("page") page : Int
    ) : RickAndMortyResponse<RickAndMortyCharacters>

    @GET("api/character/{id}")
    fun character(
        @Path("id") id: Int? = null
    ): Call<RickAndMortyCharacters>

    





}