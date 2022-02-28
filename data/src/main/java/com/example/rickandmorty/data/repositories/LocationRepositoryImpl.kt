package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.base.BaseRepository
import com.example.rickandmorty.data.remote.apiservices.LocationApiService
import com.example.rickandmorty.data.remote.dtos.toLocation
import com.example.rickandmorty.domain.models.RickAndMortyLocation
import com.example.rickandmorty.domain.repositories.LocationRepository
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(private val service: LocationApiService) :
    BaseRepository(), LocationRepository {

    override fun fetchLocations(page: Int): Flow<Resource<List<RickAndMortyLocation>>> = doRequest {
        service.fetchLocations(page).results.map { it.toLocation() }
    }
}