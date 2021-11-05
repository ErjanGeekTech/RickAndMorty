package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.modules.networkModule
import com.example.rickandmorty.modules.repositoryModule
import com.example.rickandmorty.modules.vMModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        //Start Koin
        startKoin {
            androidContext(this@App)
            androidLogger()
            modules(listOf(
                vMModule,
                repositoryModule,
                networkModule
            ))
        }
    }
}