package com.example.rickandmorty.domain.usecases

import com.example.rickandmorty.domain.repositories.LocationRepository
import javax.inject.Inject

class LocationsUseCase @Inject constructor(private val repository: LocationRepository) {

    operator fun invoke(page: Int) = repository.fetchLocations(page)
}