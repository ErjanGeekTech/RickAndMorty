package com.example.rickandmorty.ui.fragments.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repositories.CharacterRepository

class CharacterViewModel constructor(val repository: CharacterRepository) : ViewModel() {


    fun fetchCharacters() = repository.fetchCharacters().cachedIn(viewModelScope)

    fun getCharacter(id: Int? = null) = repository.getCharacterId(id)

}