package com.example.rickandmorty.ui.fragments.characters

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.ui.adapters.CharacterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
        R.layout.fragment_character
    ) {
    private val characterAdapter: CharacterAdapter = CharacterAdapter(this::onItemClick)
     override val viewModel: CharacterViewModel by sharedViewModel()
    override val binding by viewBinding(FragmentCharacterBinding::bind)


    override fun setupRequests() {
        super.setupRequests()
        fetchCharacters()
    }



    override fun setupViews() {
        super.setupViews()
        setupRecycler()

    }

    private fun setupRecycler() {
        binding.rv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = characterAdapter
        }

    }

    private fun fetchCharacters() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchCharacters().collectLatest {
                    characterAdapter.submitData(it)
                }
            }
        }
    }

    fun verifyAvailableNetwork(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }


    private fun onItemClick(id: Int) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDescriptionFragment(id)
        )
    }


}


