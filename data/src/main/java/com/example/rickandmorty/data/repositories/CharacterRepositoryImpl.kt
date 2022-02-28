package com.example.rickandmorty.data.repositories

import com.example.rickandmorty.data.base.BaseRepository
import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty.data.remote.dtos.toDomain
import com.example.rickandmorty.domain.models.RickAndMortyCharacter
import com.example.rickandmorty.domain.repositories.CharactersRepository
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private var service: CharacterApiService) :
    BaseRepository(), CharactersRepository {

    override fun fetchCharacter(id: Int): Flow<Resource<RickAndMortyCharacter>> = doRequest {
        service.fetchCharacter(id).toDomain()
    }

    override fun fetchCharacters(page: Int): Flow<Resource<List<RickAndMortyCharacter>>> = doRequest {
        service.fetchCharacters(page).results.map { it.toDomain() }
    }
}