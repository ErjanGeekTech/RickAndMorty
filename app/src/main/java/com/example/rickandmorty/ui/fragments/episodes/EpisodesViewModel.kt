package com.example.rickandmorty.ui.fragments.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repositories.EpisodeRepository

class EpisodesViewModel constructor(val repository: EpisodeRepository) : ViewModel() {

    fun fetchEpisodes() = repository.fetchEpisodes().cachedIn(viewModelScope)

}