package com.example.rickandmorty.data.remote.apiservices

import com.example.rickandmorty.data.remote.dtos.RickAndMortyLocationDto
import com.example.rickandmorty.data.remote.dtos.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("api/location")
    suspend fun fetchLocations(@Query("page") page: Int):
            Response<RickAndMortyResponse<RickAndMortyLocationDto>>
}