package com.example.rickandmorty.modules

import com.example.rickandmorty.data.network.RetrofitClient
import org.koin.dsl.module


val networkModule = module {
    single { RetrofitClient() }
    single { get<RetrofitClient>().provideCharacterApiService() }
    single { get<RetrofitClient>().provideLocationApiService() }
    single { get<RetrofitClient>().provideEpisodeApiService() }
}
