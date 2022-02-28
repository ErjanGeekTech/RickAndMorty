package com.example.rickandmorty.domain.repositories

import com.example.rickandmorty.domain.models.RickAndMortyLocation
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow

interface LocationRepository {

    fun fetchLocations(page: Int): Flow<Resource<List<RickAndMortyLocation>>>
}