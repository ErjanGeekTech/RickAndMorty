package com.example.rickandmorty.di

import com.example.rickandmorty.ui.fragments.characters.CharacterViewModel
import com.example.rickandmorty.ui.fragments.episodes.EpisodesViewModel
import com.example.rickandmorty.ui.fragments.locations.LocationsViewModel
import org.koin.dsl.module

val VmModule = module {
    single { CharacterViewModel(get()) }
    single { EpisodesViewModel(get()) }
    single { LocationsViewModel(get()) }
}