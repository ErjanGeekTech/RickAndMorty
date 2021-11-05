package com.example.rickandmorty.ui.fragments.characters

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.ui.adapters.CharacterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    R.layout.fragment_character
) {

    private val characterAdapter: CharacterAdapter = CharacterAdapter(this::onItemClick)
    override val viewModel: CharacterViewModel by sharedViewModel()
    override val binding by viewBinding(FragmentCharacterBinding::bind)

    override fun setupRequests() {
        fetchCharacters()
    }

    override fun setupViews() {
        setupRecycler()
    }

    private fun setupRecycler() = with(binding.rv) {
        layoutManager = LinearLayoutManager(context)
        adapter = characterAdapter
    }

    private fun fetchCharacters() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchCharacters().collectLatest(characterAdapter::submitData)
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(id)
        )
    }
}