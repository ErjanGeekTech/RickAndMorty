package com.example.rickandmorty.data.remote.pagingsources

import com.example.rickandmorty.base.BasePagingSource
import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty.data.remote.dtos.RickAndMortyCharacterDto
import com.example.rickandmorty.data.remote.dtos.toCharacter
import com.example.rickandmorty.domain.models.RickAndMortyCharacter


class CharacterPagingSource(private val service: CharacterApiService) :
    BasePagingSource<RickAndMortyCharacterDto, RickAndMortyCharacter>(
        { service.fetchCharacters(it) },
        { data -> data.map { it.toCharacter() } })