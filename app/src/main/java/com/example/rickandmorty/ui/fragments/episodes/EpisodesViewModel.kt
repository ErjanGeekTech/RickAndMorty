package com.example.rickandmorty.ui.fragments.episodes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.RickAndMortyRepository
import com.example.rickandmorty.models.RickAndMortyEpisodes
import com.example.rickandmorty.models.RickAndMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel
@Inject constructor(val repository: RickAndMortyRepository) : ViewModel() {

    fun fetchEpisodes(): MutableLiveData<RickAndMortyResponse<RickAndMortyEpisodes>> {
        return repository.fetchEpisodes()
    }

    fun getEpisodes(): List<RickAndMortyEpisodes> {
        return repository.getEpisodes()
    }

}