package com.example.rickandmorty.presentation.ui.fragments.main.locations

import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.base.BaseViewModel
import com.example.rickandmorty.domain.usecases.LocationsUseCase
import com.example.rickandmorty.presentation.models.RickAndMortyLocationUI
import com.example.rickandmorty.presentation.models.toLocationUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(private val locationsUseCase: LocationsUseCase) :
    BaseViewModel() {

    var page = 1
    var isLoading: Boolean = false
    private val _locationState =
        MutableStateFlow<UIState<List<RickAndMortyLocationUI>>>(UIState.Loading())
    val locationState: StateFlow<UIState<List<RickAndMortyLocationUI>>> = _locationState

    fun fetchLocations() {
        isLoading = true
        _locationState.subscribeTo({ locationsUseCase(page) }, { it.map { it.toLocationUI() } })
        page++
    }
}