package com.example.rickandmorty.presentation.ui.fragments.main.characters.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.data.remote.dtos.toCharacter
import com.example.rickandmorty.domain.models.RickAndMortyCharacter
import com.example.rickandmorty.domain.usecases.DetailCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val detailUseCase: DetailCharacterUseCase
) : BaseViewModel() {

    private val _characterState = MutableLiveData<UIState<RickAndMortyCharacter>>()
    val characterState: LiveData<UIState<RickAndMortyCharacter>> = _characterState

    fun fetchCharacter(id: Int) {
        _characterState.subscribeTo({ detailUseCase(id) }, { it.toCharacter() })
    }

}