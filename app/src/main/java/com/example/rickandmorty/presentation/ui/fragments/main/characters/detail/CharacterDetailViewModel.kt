package com.example.rickandmorty.presentation.ui.fragments.main.characters.detail

import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.domain.usecases.DetailCharacterUseCase
import com.example.rickandmorty.presentation.models.RickAndMortyCharacterUI
import com.example.rickandmorty.presentation.models.toCharacterUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val detailUseCase: DetailCharacterUseCase
) : BaseViewModel() {

    private val _characterState = MutableStateFlow<UIState<RickAndMortyCharacterUI>>(UIState.Loading())
    val characterState: StateFlow<UIState<RickAndMortyCharacterUI>> = _characterState

    fun fetchCharacter(id: Int) {
        _characterState.subscribeTo({ detailUseCase(id) }, { it.toCharacterUI() })
    }
}