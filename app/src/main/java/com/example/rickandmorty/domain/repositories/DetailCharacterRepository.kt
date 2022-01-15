package com.example.rickandmorty.domain.repositories

import com.example.rickandmorty.common.resource.Resource
import com.example.rickandmorty.data.remote.dtos.RickAndMortyCharacterDto
import kotlinx.coroutines.flow.Flow

interface DetailCharacterRepository {

    fun fetchCharacter(id: Int): Flow<Resource<RickAndMortyCharacterDto>>
}