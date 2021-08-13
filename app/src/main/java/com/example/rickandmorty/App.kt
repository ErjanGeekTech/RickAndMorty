package com.example.rickandmorty

import android.app.Application
import com.example.rickandmorty.di.NetworkModule
import com.example.rickandmorty.di.RepositoryModule
import com.example.rickandmorty.di.VmModule
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
                VmModule,
                RepositoryModule,
                NetworkModule
            ))
        }

    }


}