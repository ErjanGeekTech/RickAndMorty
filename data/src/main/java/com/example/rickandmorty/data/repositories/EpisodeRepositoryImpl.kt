package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.base.BaseRepository
import com.example.rickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty.data.remote.dtos.toEpisode
import com.example.rickandmorty.domain.models.RickAndMortyCharacter
import com.example.rickandmorty.domain.models.RickAndMortyEpisode
import com.example.rickandmorty.domain.repositories.EpisodesRepository
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EpisodeRepositoryImpl @Inject constructor(private val service: EpisodeApiService) :
    BaseRepository(), EpisodesRepository {
    override fun fetchEpisodes(page: Int): Flow<Resource<List<RickAndMortyEpisode>>> = doRequest {
        service.fetchEpisodes(page).results.map { it.toEpisode() }
    }

    override fun fetchEpisode(episode: String) = doRequest {
        service.fetchEpisode(episode).toEpisode()
    }
}