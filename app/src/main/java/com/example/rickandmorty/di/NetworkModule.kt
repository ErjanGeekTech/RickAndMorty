package com.example.rickandmorty.di

import android.net.NetworkCapabilities
import android.net.NetworkRequest
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

    @Singleton
    @Provides
    fun provideNetworkRequestClient(): NetworkRequest = NetworkRequest.Builder()
        .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
        .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
        .build()
}