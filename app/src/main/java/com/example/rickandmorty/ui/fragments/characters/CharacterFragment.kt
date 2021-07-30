package com.example.rickandmorty.ui.fragments.characters

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>() {
    val adapter: CharacterAdapter = CharacterAdapter()
    override val viewModel: CharacterViewModel by viewModels<CharacterViewModel>()


    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCharacterBinding.inflate(inflater, container, false)


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
        if (verifyAvailableNetwork()) {
            viewModel.fetchCharacters().observe(viewLifecycleOwner, { rickAndMortyResponse ->
                binding.progressCircular.visibility = View.INVISIBLE
                if (rickAndMortyResponse != null) {
                    adapter.addList(rickAndMortyResponse.results)
                }
            })
        } else {
            binding.progressCircular.visibility = View.INVISIBLE
            adapter.addList(viewModel.getCharacters())
        }
    }

    fun verifyAvailableNetwork(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

    override fun setupListener() {
        super.setupListener()
        onItemClick()
    }

    private fun onItemClick() {
        adapter.onItemClick = { id, v ->
            val action =
                CharacterFragmentDirections.actionCharacterFragmentToDescriptionFragment(id)
            Navigation.findNavController(v).navigate(action)
        }
    }


}


