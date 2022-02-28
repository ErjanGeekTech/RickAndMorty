package com.example.rickandmorty.di

import com.example.rickandmorty.data.repositories.CharacterRepositoryImpl
import com.example.rickandmorty.data.repositories.EpisodeRepositoryImpl
import com.example.rickandmorty.data.repositories.LocationRepositoryImpl
import com.example.rickandmorty.domain.repositories.CharactersRepository
import com.example.rickandmorty.domain.repositories.EpisodesRepository
import com.example.rickandmorty.domain.repositories.LocationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideCharactersRepository(
        characterRepositoryImpl: CharacterRepositoryImpl
    ): CharactersRepository

    @Binds
    abstract fun provideEpisodesRepository(
        episodeRepositoryImpl: EpisodeRepositoryImpl
    ): EpisodesRepository

    @Binds
    abstract fun provideLocationsRepository(
        locationRepositoryImpl: LocationRepositoryImpl
    ): LocationRepository
}