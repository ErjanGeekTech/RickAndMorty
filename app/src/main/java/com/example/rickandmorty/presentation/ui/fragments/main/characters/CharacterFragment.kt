package com.example.rickandmorty.presentation.ui.fragments.main.characters

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.common.resource.Resource
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.presentation.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

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

    override fun setupListeners() {
        setupLoadStateListener()
    }

    override fun setupRequests() {
        if (viewModel._charactersState.value == null) {
            viewModel.fetchCharacters()
        }
    }

    private fun setupRecycler() = with(binding.rv) {
        layoutManager = LinearLayoutManager(context)
        adapter = characterAdapter
    }

    override fun setupObserves() {
        fetchCharacters()
    }

    private fun setupLoadStateListener() {
        lifecycleScope.launch {
            characterAdapter.loadStateFlow.collectLatest { loadStates ->
                binding.characterSon.isVisible = loadStates.refresh is LoadState.Loading
            }
        }
    }

    private fun fetchCharacters() {
        if (verifyAvailableNetwork()) {
            viewModel._charactersState.observe(viewLifecycleOwner, {
                viewLifecycleOwner.lifecycleScope.launch {
                    characterAdapter.submitData(it)
                }
            })
        }
    }

    private fun firstEpisode(episode: String, position: Int) {
        viewModel.fetchEpisode(episode).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> Log.e("anime", it.message.toString())

                is Resource.Loading -> Log.e("anime", "loading")

                is Resource.Success -> {
                    characterAdapter.firstSeenIn(it.data?.name.toString(), position)
                }
            }
        })
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id)
        )
    }
}