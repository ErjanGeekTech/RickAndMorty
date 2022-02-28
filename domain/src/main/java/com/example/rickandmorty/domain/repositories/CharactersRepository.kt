package com.example.rickandmorty.domain.repositories

import com.example.rickandmorty.domain.models.RickAndMortyCharacter
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun fetchCharacters(page: Int): Flow<Resource<List<RickAndMortyCharacter>>>

    fun fetchCharacter(id: Int): Flow<Resource<RickAndMortyCharacter>>
}