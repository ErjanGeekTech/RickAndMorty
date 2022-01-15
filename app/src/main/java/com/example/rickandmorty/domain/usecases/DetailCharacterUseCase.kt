package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.DetailCharacterRepository
import javax.inject.Inject

class DetailCharacterUseCase @Inject constructor(private val repository: DetailCharacterRepository) {

    operator fun invoke(id: Int) = repository.fetchCharacter(id)
}