package com.example.rickandmorty.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.data.network.apiservice.EpisodeApiService
import com.example.rickandmorty.data.repositories.pagingSource.EpisodePagingSource
import com.example.rickandmorty.models.RickAndMortyEpisodes
import kotlinx.coroutines.flow.Flow

class EpisodeRepository constructor(val service: EpisodeApiService) {

    fun fetchEpisodes(): Flow<PagingData<RickAndMortyEpisodes>> {
        return Pager(config =
        PagingConfig(pageSize = 10, enablePlaceholders = false),
            pagingSourceFactory = {
                EpisodePagingSource(service)
            }).flow
    }

}