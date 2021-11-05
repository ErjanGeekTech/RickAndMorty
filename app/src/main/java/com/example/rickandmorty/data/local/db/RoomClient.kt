package com.example.rickandmorty.data.local.db

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.data.local.db.daos.EpisodesDao
import com.example.rickandmorty.data.local.db.daos.LocationDao

class RoomClient {

    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "rickAndMorty.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }

    fun provideCharacterDao(appDatabase: AppDatabase) = appDatabase.characterDao()

    fun provideEpisodeDao(appDatabase: AppDatabase): EpisodesDao = appDatabase.episodeDao()

    fun provideLocationDao(appDatabase: AppDatabase): LocationDao = appDatabase.locationDao()
}