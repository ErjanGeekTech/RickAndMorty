package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.data.network.RetrofitClient
import com.example.rickandmorty.data.network.apiservice.RickAndMortyApiService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {


    override fun onCreate() {
        super.onCreate()
    }

}