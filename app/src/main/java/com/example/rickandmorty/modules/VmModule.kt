package com.example.rickandmorty.modules

import com.example.rickandmorty.ui.fragments.characters.CharacterViewModel
import com.example.rickandmorty.ui.fragments.episodes.EpisodesViewModel
import com.example.rickandmorty.ui.fragments.locations.LocationsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val vMModule = module {
    viewModel { CharacterViewModel(get()) }
    viewModel { EpisodesViewModel(get()) }
    viewModel { LocationsViewModel(get()) }
}