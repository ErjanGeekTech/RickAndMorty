package com.example.rickandmorty.ui.fragments.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel
@Inject constructor(val repository: LocationRepository) : ViewModel() {

    fun fetchLocations() = repository.fetchLocation().cachedIn(viewModelScope)


}