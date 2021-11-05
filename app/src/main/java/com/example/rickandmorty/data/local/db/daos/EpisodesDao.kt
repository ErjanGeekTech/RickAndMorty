package com.example.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.models.RickAndMortyEpisodes
import java.util.ArrayList

@Dao
interface EpisodesDao {

    @Query("SELECT * FROM rickandmortyepisodes")
    fun getAll(): List<RickAndMortyEpisodes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters: ArrayList<RickAndMortyEpisodes>)

}