package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.base.BaseRepository
import com.example.rickandmorty.common.resource.Resource
import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty.data.remote.dtos.RickAndMortyCharacterDto
import com.example.rickandmorty.data.remote.pagingsources.CharacterPagingSource
import com.example.rickandmorty.domain.repositories.DetailCharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepository @Inject constructor(private var service: CharacterApiService) :
    BaseRepository(), DetailCharacterRepository {

    fun fetchCharacters() = doPagingRequest(CharacterPagingSource(service))

    override fun fetchCharacter(id: Int): Flow<Resource<RickAndMortyCharacterDto>> = doRequest {
        service.fetchCharacter(id)
    }
}