package com.example.rickandmorty.di

import com.example.rickandmorty.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideCharacterApiService() = retrofitClient.provideCharacterApiService()

    @Singleton
    @Provides
    fun provideEpisodeService() = retrofitClient.provideEpisodeApiService()

    @Singleton
    @Provides
    fun provideLocationApiService() = retrofitClient.provideLocationApiService()
}