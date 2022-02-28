package com.example.rickandmorty.presentation.ui.fragments.main.episodes

import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.domain.usecases.EpisodesUseCase
import com.example.rickandmorty.presentation.models.RickAndMortyEpisodeUI
import com.example.rickandmorty.presentation.models.toEpisodeUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(private val episodeUseCase: EpisodesUseCase) :
    BaseViewModel() {

    var page = 1
    var isLoading: Boolean = false
    private val _episodesState =
        MutableStateFlow<UIState<List<RickAndMortyEpisodeUI>>>(UIState.Loading())
    val episodesState: StateFlow<UIState<List<RickAndMortyEpisodeUI>>> = _episodesState

    fun fetchEpisodes() {
        isLoading = true
        _episodesState.subscribeTo({ episodeUseCase(page) }, { it.map { it.toEpisodeUI() } })
        page++
    }
}