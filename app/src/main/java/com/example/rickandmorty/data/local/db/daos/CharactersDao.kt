package com.example.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.models.RickAndMortyCharacters
import java.util.*

@Dao
interface CharactersDao {

    @Query("SELECT * FROM rickandmortycharacters")
    fun getAll(): List<RickAndMortyCharacters>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters: ArrayList<RickAndMortyCharacters>)
}