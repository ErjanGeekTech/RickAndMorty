package com.example.rickandmorty.presentation.ui.fragments.main.locations

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentLocationsBinding
import com.example.rickandmorty.presentation.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationsViewModel>(
    R.layout.fragment_locations
) {

    override val viewModel: LocationsViewModel by viewModels()
    private val locationAdapter: LocationAdapter = LocationAdapter()
    override val binding by viewBinding(FragmentLocationsBinding::bind)

    override fun setupViews() {
        setupRecycler()
    }

    private fun setupRecycler() = with(binding.rv) {
        layoutManager = LinearLayoutManager(context)
        adapter = locationAdapter
    }

    override fun setupRequests() {
        fetchLocations()
    }

    override fun setupListeners() {
        setupLoadStateListener()
    }

    private fun setupLoadStateListener() {
        lifecycleScope.launch {
            locationAdapter.loadStateFlow.collectLatest { loadStates ->
                binding.locationsProgressBar.isVisible = loadStates.refresh is LoadState.Loading
            }
        }
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchLocations().collectLatest(locationAdapter::submitData)
            }
        }
    }
}