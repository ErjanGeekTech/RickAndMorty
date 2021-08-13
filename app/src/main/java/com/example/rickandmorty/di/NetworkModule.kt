package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.RetrofitClient
import org.koin.dsl.module


val NetworkModule = module {

    single { RetrofitClient().retrofit }
    single { RetrofitClient().provideHttpLoggingInterceptor() }
    single { RetrofitClient().provideCharacterApiService() }
    single { RetrofitClient().provideEpisodeApiService() }
    single { RetrofitClient().provideLocationApiService() }

}
//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    @Singleton
//    val retrofitClient: RetrofitClient = RetrofitClient()
//
//    @Singleton
//    @Provides
//    fun provideCharacterApiService(): CharacterApiService {
//        return retrofitClient.provideCharacterApiService()
//    }
//
//    @Singleton
//    @Provides
//    fun provideEpisodeApiService(): EpisodeApiService {
//        return retrofitClient.provideEpisodeApiService()
//    }
//
//    @Singleton
//    @Provides
//    fun provideLocationApiService(): LocationApiService {
//        return retrofitClient.provideLocationApiService()
//    }

//}