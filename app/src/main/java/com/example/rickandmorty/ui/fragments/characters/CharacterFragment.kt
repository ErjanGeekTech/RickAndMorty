package com.example.rickandmorty.ui.fragments.characters

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>() {

    val adapter: CharacterAdapter = CharacterAdapter()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharacterBinding.inflate(inflater, container, false)

    override fun getViewModel() = CharacterViewModel::class.java

    override fun setupRequests() {
        super.setupRequests()
        fetchCharacters()
    }

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = adapter
    }

    private fun fetchCharacters() {
        if (verifyAvailableNetwork()){
            viewModel.fetchCharacters().observe(viewLifecycleOwner, {rickAndMortyResponse->
//                binding.progressCircular.setVisibility(View.INVISIBLE)
                if (rickAndMortyResponse != null) {
                        adapter.addList(rickAndMortyResponse.results)
                    }
            })
        }
    }

    fun verifyAvailableNetwork(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }


}