package com.example.rickandmorty.ui.fragments.characters

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentCharacterBinding
import com.example.rickandmorty.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment :
    BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
        R.layout.fragment_character
    ) {
    val adapter: CharacterAdapter = CharacterAdapter(this::onItemClick)
    override val viewModel: CharacterViewModel by activityViewModels()
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
        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = adapter
    }

    private fun fetchCharacters() {
        if (verifyAvailableNetwork()) {

            lifecycleScope.launch {
                viewModel.fetchCharacters().collectLatest {
                    adapter.submitData(it)
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


