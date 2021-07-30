package com.example.rickandmorty.ui.fragments.locations

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.data.repositories.RickAndMortyRepository
import com.example.rickandmorty.models.RickAndMortyLocations
import com.example.rickandmorty.models.RickAndMortyResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel
@Inject constructor(val repository: RickAndMortyRepository) : ViewModel() {

    fun fetchLocations(): MutableLiveData<RickAndMortyResponse<RickAndMortyLocations>> {
        return repository.fetchLocations()
    }

    fun getLocations(): List<RickAndMortyLocations> {
        return repository.getLocations()
    }

}