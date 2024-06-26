package com.example.rickandmorty.data.remote

import com.example.rickandmorty.constants.Constants.BASE_URL
import com.example.rickandmorty.data.remote.apiservices.CharacterApiService
import com.example.rickandmorty.data.remote.apiservices.EpisodeApiService
import com.example.rickandmorty.data.remote.apiservices.LocationApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient: OkHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(provideHttpLoggingInterceptor())
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private fun provideHttpLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideCharacterApiService(): CharacterApiService =
        retrofit.create(CharacterApiService::class.java)

    fun provideEpisodeApiService(): EpisodeApiService =
        retrofit.create(EpisodeApiService::class.java)

    fun provideLocationApiService(): LocationApiService =
        retrofit.create(LocationApiService::class.java)
}