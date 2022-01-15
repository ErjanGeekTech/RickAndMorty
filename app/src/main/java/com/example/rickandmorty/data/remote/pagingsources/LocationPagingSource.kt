package com.example.rickandmorty.data.remote.pagingsources

import com.example.rickandmorty.base.BasePagingSource
import com.example.rickandmorty.data.remote.apiservices.LocationApiService
import com.example.rickandmorty.data.remote.dtos.RickAndMortyLocationDto
import com.example.rickandmorty.data.remote.dtos.toLocation
import com.example.rickandmorty.domain.models.RickAndMortyLocation

class LocationPagingSource(private val service: LocationApiService) :
    BasePagingSource<RickAndMortyLocationDto, RickAndMortyLocation>(
        { service.fetchLocations(it) },
        { data -> data.map { it.toLocation() } })