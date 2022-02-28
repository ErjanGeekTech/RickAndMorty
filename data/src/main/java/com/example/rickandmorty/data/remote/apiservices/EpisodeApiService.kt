package com.example.rickandmorty.data.remote.apiservices

import com.example.rickandmorty.data.remote.dtos.RickAndMortyEpisodeDto
import com.example.rickandmorty.data.remote.dtos.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface EpisodeApiService {

    @GET("api/episode")
    suspend fun fetchEpisodes(@Query("page") page: Int): RickAndMortyResponse<RickAndMortyEpisodeDto>

    @GET
    suspend fun fetchEpisode(@Url url: String): RickAndMortyEpisodeDto
}