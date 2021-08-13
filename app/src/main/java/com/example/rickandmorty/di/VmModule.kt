package com.example.rickandmorty.di

import com.example.rickandmorty.ui.fragments.characters.CharacterViewModel
import com.example.rickandmorty.ui.fragments.episodes.EpisodesViewModel
import com.example.rickandmorty.ui.fragments.locations.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VmModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { LocationsViewModel(get()) }
}