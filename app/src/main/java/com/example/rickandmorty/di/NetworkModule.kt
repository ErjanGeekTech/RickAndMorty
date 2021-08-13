package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.RetrofitClient
import org.koin.dsl.module


val NetworkModule = module {

    single { RetrofitClient().provideHttpLoggingInterceptor() }
    single{
        get<RetrofitClient>().retrofit
    }
    single { RetrofitClient().provideCharacterApiService() }
    single { RetrofitClient().provideEpisodeApiService() }
    single { RetrofitClient().provideLocationApiService() }

}
