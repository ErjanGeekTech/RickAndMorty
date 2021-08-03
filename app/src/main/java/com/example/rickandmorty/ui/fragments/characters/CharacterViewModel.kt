package com.example.rickandmorty.ui.fragments.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repositories.CharacterRepository
import com.example.rickandmorty.models.RickAndMortyCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(val repository: CharacterRepository) : ViewModel() {


    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)

    fun getCharacter(id: Int? = null): MutableLiveData<RickAndMortyCharacters> {
        return repository.getCharacterId(id)
    }

}