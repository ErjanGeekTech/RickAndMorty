package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.CharactersRepository
import javax.inject.Inject

class DetailCharacterUseCase @Inject constructor(private val repository: CharactersRepository) {

    operator fun invoke(id: Int) = repository.fetchCharacter(id)
}