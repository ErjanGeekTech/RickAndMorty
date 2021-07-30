package com.example.rickandmorty.data.db

import android.content.Context
import androidx.room.Room
import com.example.rickandmorty.data.db.daos.CharactersDao
import com.example.rickandmorty.data.db.daos.EpisodesDao
import com.example.rickandmorty.data.db.daos.LocationDao

class RoomClient {

    fun provideRoom(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "rickAndMorty.db"
        ).allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
    }


    fun provideCharacterDao(appDatabase: AppDatabase): CharactersDao{
        return appDatabase.characterDao()
    }
    fun provideEpisodeDao(appDatabase: AppDatabase): EpisodesDao{
        return appDatabase.episodeDao()
    }
    fun provideLocationDao(appDatabase: AppDatabase): LocationDao{
        return appDatabase.locationDao()
    }


}