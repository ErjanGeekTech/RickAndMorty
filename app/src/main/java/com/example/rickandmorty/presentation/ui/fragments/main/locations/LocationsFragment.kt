package com.example.rickandmorty.presentation.ui.fragments.main.locations

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.submitData
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentLocationsBinding
import com.example.rickandmorty.presentation.ui.adapters.LocationAdapter
import com.example.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

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
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = locationAdapter

        addOnScrollListener(object :
            PaginationScrollListener(linearLayoutManager, { viewModel.fetchLocations() }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    override fun setupRequests() {
        if (locationAdapter.currentList.isEmpty()) viewModel.fetchLocations()
    }

    override fun setupObserves() {
        fetchLocations()
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            viewModel.locationState.subscribe {
                when (it) {
                    is UIState.Loading -> {

                    }
                    is UIState.Error -> {

                    }
                    is UIState.Success -> {
                        locationAdapter.submitData(it.data)
                        viewModel.isLoading = false
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewModel.page = 1
    }
}