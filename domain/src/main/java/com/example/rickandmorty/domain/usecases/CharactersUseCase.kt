package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.CharactersRepository
import javax.inject.Inject

class CharactersUseCase @Inject constructor(private val repository: CharactersRepository) {

    operator fun invoke(page: Int) = repository.fetchCharacters(page)
}