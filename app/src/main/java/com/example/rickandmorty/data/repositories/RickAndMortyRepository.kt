package com.example.rickandmorty.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.data.db.daos.CharactersDao
import com.example.rickandmorty.data.db.daos.EpisodesDao
import com.example.rickandmorty.data.db.daos.LocationDao
import com.example.rickandmorty.data.network.apiservice.RickAndMortyApiService
import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyEpisodes
import com.example.rickandmorty.models.RickAndMortyLocations
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepository
@Inject constructor(
    var service: RickAndMortyApiService, var charactersDao: CharactersDao,
    var episodesDao: EpisodesDao, var locationDao: LocationDao
) {

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<RickAndMortyCharacters>> {
        var characters: MutableLiveData<RickAndMortyResponse<RickAndMortyCharacters>> =
            MutableLiveData()
        service.fetchCharacters()
            .enqueue(object : Callback<RickAndMortyResponse<RickAndMortyCharacters>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<RickAndMortyCharacters>>,
                    response: Response<RickAndMortyResponse<RickAndMortyCharacters>>
                ) {
                    if (response.body() != null) {
                        charactersDao.insertAll(response.body()!!.results)
                    }
                    characters.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<RickAndMortyCharacters>>,
                    t: Throwable
                ) {
                    characters.value = null
                }
            })
        return characters
    }

    fun getCharacters(): List<RickAndMortyCharacters> {
        var listCharacter: List<RickAndMortyCharacters> = ArrayList()
        listCharacter = charactersDao.getAll()
        return listCharacter
    }

    fun fetchEpisodes(): MutableLiveData<RickAndMortyResponse<RickAndMortyEpisodes>> {
        var episodes: MutableLiveData<RickAndMortyResponse<RickAndMortyEpisodes>> =
            MutableLiveData()
        service.fetchEpisodes()
            .enqueue(object : Callback<RickAndMortyResponse<RickAndMortyEpisodes>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<RickAndMortyEpisodes>>,
                    response: Response<RickAndMortyResponse<RickAndMortyEpisodes>>
                ) {
                    if (response.body() != null) {
                        episodesDao.insertAll(response.body()!!.results)
                    }
                    episodes.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<RickAndMortyEpisodes>>,
                    t: Throwable
                ) {
                    episodes.value = null
                }

            })
        return episodes
    }

    fun getEpisodes(): List<RickAndMortyEpisodes> {
        var listCharacter: List<RickAndMortyEpisodes> = ArrayList()
        listCharacter = episodesDao.getAll()
        return listCharacter
    }

    fun fetchLocations(): MutableLiveData<RickAndMortyResponse<RickAndMortyLocations>> {
        var locations: MutableLiveData<RickAndMortyResponse<RickAndMortyLocations>> =
            MutableLiveData()
        service.fetchLocations()
            .enqueue(object : Callback<RickAndMortyResponse<RickAndMortyLocations>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<RickAndMortyLocations>>,
                    response: Response<RickAndMortyResponse<RickAndMortyLocations>>
                ) {
                    if (response.body() != null) {
                        locationDao.insertAll(response.body()!!.results)
                    }
                    locations.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<RickAndMortyLocations>>,
                    t: Throwable
                ) {
                    locations.value = null
                }
            })
        return locations
    }

    fun getLocations(): List<RickAndMortyLocations> {
        var listCharacter: List<RickAndMortyLocations> = ArrayList()
        listCharacter = locationDao.getAll()
        return listCharacter
    }

    fun getCharacterId(id: Int? = null): MutableLiveData<RickAndMortyCharacters> {
        var character: MutableLiveData<RickAndMortyCharacters> = MutableLiveData()
        service.character(id).enqueue(object : Callback<RickAndMortyCharacters> {
            override fun onResponse(
                call: Call<RickAndMortyCharacters>,
                response: Response<RickAndMortyCharacters>
            ) {
                character.value = response.body()
            }

            override fun onFailure(call: Call<RickAndMortyCharacters>, t: Throwable) {
                character.value = null
            }

        })
        return character
    }

}