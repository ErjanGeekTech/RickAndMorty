package com.example.rickandmorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rickandmorty.data.db.daos.CharactersDao
import com.example.rickandmorty.data.db.daos.EpisodesDao
import com.example.rickandmorty.data.db.daos.LocationDao
import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyEpisodes
import com.example.rickandmorty.models.RickAndMortyLocations

@Database(entities = arrayOf(RickAndMortyCharacters::class, RickAndMortyLocations::class, RickAndMortyEpisodes::class), version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharactersDao
    abstract fun episodeDao(): EpisodesDao
    abstract fun locationDao(): LocationDao

}