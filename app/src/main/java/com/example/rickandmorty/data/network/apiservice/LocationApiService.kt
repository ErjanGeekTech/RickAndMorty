package com.example.rickandmorty.data.network.apiservice

import com.example.rickandmorty.models.RickAndMortyLocations
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {
    @GET("api/location")
   suspend fun fetchLocations(
        @Query("page") page: Int
    ): RickAndMortyResponse<RickAndMortyLocations>

}