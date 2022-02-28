package com.example.rickandmorty.domain.repositories

import com.example.rickandmorty.domain.models.RickAndMortyEpisode
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow

interface EpisodesRepository {

    fun fetchEpisodes(page: Int): Flow<Resource<List<RickAndMortyEpisode>>>

    fun fetchEpisode(episode: String): Flow<Resource<RickAndMortyEpisode>>
}