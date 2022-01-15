package com.example.rickandmorty.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.common.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <TDomain, T> MutableLiveData<UIState<T>>.subscribeTo(
        request: () -> Flow<Resource<TDomain>>,
        mappedData: (TDomain) -> T
    ) {
        viewModelScope.launch {
            request().collect {
                when (it) {
                    is Resource.Loading -> {
                        this@subscribeTo.value = UIState.Loading()
                    }
                    is Resource.Error -> it.message?.let { error ->
                        this@subscribeTo.value = UIState.Error(error)
                    }
                    is Resource.Success -> it.data?.let { data ->
                        this@subscribeTo.value = UIState.Success(mappedData(data))
                    }
                }
            }
        }
    }
}