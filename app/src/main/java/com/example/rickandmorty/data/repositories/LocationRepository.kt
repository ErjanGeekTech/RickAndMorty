package com.example.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.data.network.apiservice.LocationApiService
import com.example.rickandmorty.data.repositories.pagingSource.LocationPagingSource
import com.example.rickandmorty.models.RickAndMortyLocations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocationRepository @Inject constructor(val service: LocationApiService) {

    fun fetchLocation(): Flow<PagingData<RickAndMortyLocations>> {
        return Pager(config = PagingConfig(
            pageSize = 10, enablePlaceholders = false
        ), pagingSourceFactory = {
            LocationPagingSource(service)
        }).flow
    }

}