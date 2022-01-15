package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.FirstEpisodeRepository
import javax.inject.Inject

class FirstEpisodeUseCase @Inject constructor(private val repository: FirstEpisodeRepository) {

    operator fun invoke(episode: String) = repository.fetchEpisode(episode)
}