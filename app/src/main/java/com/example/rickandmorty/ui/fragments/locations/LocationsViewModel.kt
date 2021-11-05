package com.example.rickandmorty.ui.fragments.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repositories.LocationRepository

class LocationsViewModel constructor(private val repository: LocationRepository) : ViewModel() {

    fun fetchLocations() = repository.fetchLocation().cachedIn(viewModelScope)
}