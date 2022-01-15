package com.example.rickandmorty.presentation.ui.fragments.main.episodes

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.data.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel @Inject constructor(private val repository: EpisodeRepository) :
    BaseViewModel() {

    fun fetchEpisodes() = repository.fetchEpisodes().cachedIn(viewModelScope)
}