package com.example.rickandmorty.ui.fragments.description

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.RickAndMortyRepository
import com.example.rickandmorty.models.RickAndMortyCharacters
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel
@Inject constructor(val repository: RickAndMortyRepository) : ViewModel() {
    fun getCharacter(id: Int? = null): MutableLiveData<RickAndMortyCharacters> {
        return repository.getCharacterId(id)
    }
}