package com.example.rickandmorty.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmorty.data.network.apiservice.CharacterApiService
import com.example.rickandmorty.data.repositories.pagingSource.CharacterPagingSource
import com.example.rickandmorty.models.RickAndMortyCharacters
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response

class CharacterRepository constructor(private var service: CharacterApiService) {

    fun fetchCharacters(): Flow<PagingData<RickAndMortyCharacters>> {
        return Pager(config = PagingConfig(
            pageSize = 10, enablePlaceholders = false
        ), pagingSourceFactory = {
            CharacterPagingSource(service)
        }).flow
    }

    fun getCharacterId(id: Int? = null): MutableLiveData<RickAndMortyCharacters> {
        val character: MutableLiveData<RickAndMortyCharacters> = MutableLiveData()
        service.character(id).enqueue(object : retrofit2.Callback<RickAndMortyCharacters> {
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