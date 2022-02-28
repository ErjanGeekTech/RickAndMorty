package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.EpisodesRepository
import javax.inject.Inject

class FirstEpisodeUseCase @Inject constructor(private val repository: EpisodesRepository) {

    operator fun invoke(episode: String) = repository.fetchEpisode(episode)
}