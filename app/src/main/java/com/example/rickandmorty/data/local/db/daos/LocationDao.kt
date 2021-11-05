package com.example.rickandmorty.data.local.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.rickandmorty.models.RickAndMortyLocations
import java.util.ArrayList

@Dao
interface LocationDao {
    @Query("SELECT * FROM rickandmortylocations")
    fun getAll(): List<RickAndMortyLocations>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters: ArrayList<RickAndMortyLocations>)
}