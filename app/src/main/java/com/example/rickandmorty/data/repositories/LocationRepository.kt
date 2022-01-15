package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.base.BaseRepository
import com.example.rickandmorty.data.remote.apiservices.LocationApiService
import com.example.rickandmorty.data.remote.pagingsources.LocationPagingSource
import javax.inject.Inject

class LocationRepository @Inject constructor(private val service: LocationApiService) :
    BaseRepository() {

    fun fetchLocation() = doPagingRequest(LocationPagingSource(service))

}