package com.example.rickandmorty.presentation.ui.fragments.main.locations

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(private val repository: LocationRepository) :
    BaseViewModel() {

    fun fetchLocations() = repository.fetchLocation().cachedIn(viewModelScope)
}