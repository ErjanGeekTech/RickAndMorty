package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.EpisodesRepository
import javax.inject.Inject

class EpisodesUseCase @Inject constructor(private val repository: EpisodesRepository) {

    operator fun invoke(page: Int) = repository.fetchEpisodes(page)
}