package com.example.rickandmorty.presentation.ui.fragments.main.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.data.repositories.CharacterRepository
import com.example.rickandmorty.domain.models.RickAndMortyCharacter
import com.example.rickandmorty.domain.usecases.FirstEpisodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
    private val firstEpisodeUseCase: FirstEpisodeUseCase
) : BaseViewModel() {

    private val _charactersState = MutableLiveData<PagingData<RickAndMortyCharacter>>()
    val charactersState: LiveData<PagingData<RickAndMortyCharacter>> = _charactersState

    fun fetchCharacters() {
        viewModelScope.launch {
            repository.fetchCharacters().cachedIn(viewModelScope).collectLatest {
                _charactersState.postValue(it)
            }
        }
    }

    fun fetchEpisode(episode: String) = firstEpisodeUseCase(episode).asLiveData()
}