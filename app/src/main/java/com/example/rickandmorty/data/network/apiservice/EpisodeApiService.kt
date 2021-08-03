package com.example.rickandmorty.data.network.apiservice

import com.example.rickandmorty.models.RickAndMortyEpisodes
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {
    @GET("api/episode")
   suspend fun getListEpisode(
        @Query("page") page : Int
   ): RickAndMortyResponse<RickAndMortyEpisodes>
}