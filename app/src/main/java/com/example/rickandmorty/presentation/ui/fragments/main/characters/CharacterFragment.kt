package com.example.rickandmorty.presentation.ui.fragments.main.characters

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.submitData
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.resource.Resource
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.presentation.ui.adapters.CharacterAdapter
import com.example.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    R.layout.fragment_character
) {

    private val characterAdapter = CharacterAdapter(this::onItemClick, this::firstEpisode)
    override val viewModel: CharacterViewModel by viewModels()
    override val binding by viewBinding(FragmentCharacterBinding::bind)

    override fun setupViews() {
        setupRecycler()
    }

    override fun setupObserves() {
        fetchCharacters()
    }

    override fun setupRequests() {
        if(characterAdapter.currentList.isEmpty()){
            viewModel.fetchCharacters()
        }
    }

    private fun setupRecycler() = with(binding.rv) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = characterAdapter

        addOnScrollListener(object : PaginationScrollListener(linearLayoutManager, { viewModel.fetchCharacters() }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun fetchCharacters() {
        if (verifyAvailableNetwork()) {
            viewModel.charactersState.subscribe {
                when (it) {
                    is UIState.Loading -> {
                    }
                    is UIState.Error -> {
                        Log.e("anime", it.error)
                    }
                    is UIState.Success -> {
                        binding.characterProgressBar.isVisible = false
                        characterAdapter.submitData(it.data)
                        viewModel.isLoading = false
                    }
                }
            }
        }
    }

    private fun firstEpisode(episode: String, position: Int) {
        viewModel.fetchEpisode(episode).observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> Log.e("anime", it.message.toString())

                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    characterAdapter.firstSeenIn(it.data?.name.toString(), position)
                }
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id)
        )
    }
}