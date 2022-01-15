package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.base.BaseRepository
import com.example.rickandmorty.common.resource.Resource
import com.example.rickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty.data.remote.dtos.RickAndMortyEpisodeDto
import com.example.rickandmorty.data.remote.pagingsources.EpisodePagingSource
import com.example.rickandmorty.domain.repositories.FirstEpisodeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepository @Inject constructor(private val service: EpisodeApiService) :
    BaseRepository(), FirstEpisodeRepository {

    fun fetchEpisodes() = doPagingRequest(EpisodePagingSource(service))

    override fun fetchEpisode(episode: String): Flow<Resource<RickAndMortyEpisodeDto>>  =
        doRequest {
            service.fetchEpisode(episode)
        }
}