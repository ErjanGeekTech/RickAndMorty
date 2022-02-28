package com.example.rickandmorty.presentation.ui.fragments.main.characters

import androidx.lifecycle.asLiveData
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.domain.usecases.CharactersUseCase
import com.example.rickandmorty.domain.usecases.FirstEpisodeUseCase
import com.example.rickandmorty.presentation.models.RickAndMortyCharacterUI
import com.example.rickandmorty.presentation.models.toCharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val firstEpisodeUseCase: FirstEpisodeUseCase,
    private val charactersUseCase: CharactersUseCase
) : BaseViewModel() {

    var page = 1
    var isLoading: Boolean = false
    private val _charactersState =
        MutableStateFlow<UIState<List<RickAndMortyCharacterUI>>>(UIState.Loading())
    val charactersState: StateFlow<UIState<List<RickAndMortyCharacterUI>>> = _charactersState

    fun fetchCharacters() {
        isLoading = true
        _charactersState.subscribeTo({ charactersUseCase(page) }, { it.map { it.toCharacterUI() } })
        page++
    }

    fun fetchEpisode(episode: String) = firstEpisodeUseCase(episode).asLiveData()
}