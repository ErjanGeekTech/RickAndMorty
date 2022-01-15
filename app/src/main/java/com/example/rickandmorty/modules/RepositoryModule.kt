package com.example.rickandmorty.modules

import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty.data.repositories.CharacterRepository
import com.example.rickandmorty.data.repositories.EpisodeRepository
import com.example.rickandmorty.domain.repositories.DetailCharacterRepository
import com.example.rickandmorty.domain.repositories.FirstEpisodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideCharacterRepository(service: CharacterApiService): DetailCharacterRepository =
        CharacterRepository(service)

    @Singleton
    @Provides
    fun provideLocationRepository(service: EpisodeApiService): FirstEpisodeRepository =
        EpisodeRepository(service)
}