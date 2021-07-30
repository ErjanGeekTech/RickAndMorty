package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.RetrofitClient
import com.example.rickandmorty.data.network.apiservice.RickAndMortyApiService
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
    fun provideCharacterApiService(): RickAndMortyApiService {
        return RetrofitClient().provideRickAndMortyApiService()
    }

}