package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.RetrofitClient
import com.example.rickandmorty.data.network.apiservice.CharacterApiService
import com.example.rickandmorty.data.network.apiservice.EpisodeApiService
import com.example.rickandmorty.data.network.apiservice.LocationApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideCharacterApiService(): CharacterApiService {
        return RetrofitClient().provideCharacterApiService()
    }

    @Singleton
    @Provides
    fun provideEpisodeApiService(): EpisodeApiService {
        return RetrofitClient().provideEpisodeApiService()
    }

    @Singleton
    @Provides
    fun provideLocationApiService(): LocationApiService {
        return RetrofitClient().provideLocationApiService()
    }

}