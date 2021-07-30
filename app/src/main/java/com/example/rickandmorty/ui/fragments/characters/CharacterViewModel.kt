package com.example.rickandmorty.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.RickAndMortyRepository
import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(val repository: RickAndMortyRepository) : ViewModel() {


    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<RickAndMortyCharacters>> {
        return repository.fetchCharacters()
    }

    fun getCharacters(): List<RickAndMortyCharacters> {
        return repository.getCharacters()
    }



}