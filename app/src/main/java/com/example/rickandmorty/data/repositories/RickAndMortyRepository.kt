package com.example.rickandmorty.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.rickandmorty.App
import com.example.rickandmorty.data.network.apiservice.RickAndMortyApiService
import com.example.rickandmorty.models.RickAndMortyCharacters
import com.example.rickandmorty.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RickAndMortyRepository
@Inject constructor( var service: RickAndMortyApiService)
{

    fun fetchCharacters(): MutableLiveData<RickAndMortyResponse<RickAndMortyCharacters>>{
        var characters: MutableLiveData<RickAndMortyResponse<RickAndMortyCharacters>> = MutableLiveData()
        service.fetchCharacters().enqueue(object : Callback<RickAndMortyResponse<RickAndMortyCharacters>>{
            override fun onResponse(
                call: Call<RickAndMortyResponse<RickAndMortyCharacters>>,
                response: Response<RickAndMortyResponse<RickAndMortyCharacters>>
            ) {
                characters.value= response.body()

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

}