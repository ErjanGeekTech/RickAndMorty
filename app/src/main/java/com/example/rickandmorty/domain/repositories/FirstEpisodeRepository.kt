package com.example.rickandmorty.domain.repositories

import com.example.rickandmorty.common.resource.Resource
import com.example.rickandmorty.data.remote.dtos.RickAndMortyEpisodeDto
import kotlinx.coroutines.flow.Flow

interface FirstEpisodeRepository {

    fun fetchEpisode(episode: String): Flow<Resource<RickAndMortyEpisodeDto>>
}