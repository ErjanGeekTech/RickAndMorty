package com.example.rickandmorty.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <TDomain, T> MutableStateFlow<UIState<T>>.subscribeTo(
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