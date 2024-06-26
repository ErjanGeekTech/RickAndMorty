package com.example.rickandmorty.data.remote.apiservices

import com.example.rickandmorty.data.remote.dtos.RickAndMortyCharacterDto
import com.example.rickandmorty.data.remote.dtos.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("api/character")
    suspend fun fetchCharacters(@Query("page") page: Int):
            RickAndMortyResponse<RickAndMortyCharacterDto>

    @GET("api/character/{id}")
    suspend fun fetchCharacter(@Path("id") id: Int): RickAndMortyCharacterDto
}