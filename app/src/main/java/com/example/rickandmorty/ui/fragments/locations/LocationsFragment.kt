package com.example.rickandmorty.ui.fragments.locations

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentLocationsBinding
import com.example.rickandmorty.ui.adapters.LocationAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationsViewModel>(
    R.layout.fragment_locations
) {

    override val viewModel: LocationsViewModel by viewModel()
    private val locationAdapter: LocationAdapter = LocationAdapter()
    override val binding by viewBinding(FragmentLocationsBinding::bind)

    override fun setupRequests() {
        fetchLocations()
    }

    override fun setupViews() {
        setupRecycler()
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchLocations().collectLatest(locationAdapter::submitData)
            }
        }
    }

    private fun setupRecycler() = with(binding.rv) {
        layoutManager = LinearLayoutManager(context)
        adapter = locationAdapter
    }
}