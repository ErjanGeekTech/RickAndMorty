package com.example.rickandmorty.data.remote.pagingsources

import com.example.rickandmorty.base.BasePagingSource
import com.example.rickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty.data.remote.dtos.RickAndMortyEpisodeDto
import com.example.rickandmorty.data.remote.dtos.toEpisode
import com.example.rickandmorty.domain.models.RickAndMortyEpisode

class EpisodePagingSource(private val service: EpisodeApiService) :
    BasePagingSource<RickAndMortyEpisodeDto, RickAndMortyEpisode>(
        { service.fetchEpisodes(it) },
        { data -> data.map { it.toEpisode() } })