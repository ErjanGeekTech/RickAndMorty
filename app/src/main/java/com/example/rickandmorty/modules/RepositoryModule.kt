package com.example.rickandmorty.modules

import com.example.rickandmorty.data.repositories.CharacterRepository
import com.example.rickandmorty.data.repositories.EpisodeRepository
import com.example.rickandmorty.data.repositories.LocationRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory { CharacterRepository(get()) }
    factory { EpisodeRepository(get()) }
    factory { LocationRepository(get()) }
}