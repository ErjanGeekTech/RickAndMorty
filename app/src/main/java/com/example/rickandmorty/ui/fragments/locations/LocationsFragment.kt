package com.example.rickandmorty.ui.fragments.locations

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentLocationsBinding
import com.example.rickandmorty.ui.adapters.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationsViewModel>() {
    override val viewModel: LocationsViewModel by viewModels<LocationsViewModel>()
    val adapter: LocationAdapter = LocationAdapter()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentLocationsBinding.inflate(inflater, container, false)

    override fun setupRequests() {
        super.setupRequests()
        fetchLocations()
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            viewModel.fetchLocations().observe(viewLifecycleOwner, { rickAndMortyLocations ->
                binding.progressCircular.setVisibility(View.INVISIBLE)
                if (rickAndMortyLocations != null)
                    adapter.addList(rickAndMortyLocations.results)
            })
        } else {
            binding.progressCircular.setVisibility(View.INVISIBLE)
            adapter.addList(viewModel.getLocations())
        }
    }

    fun verifyAvailableNetwork(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = adapter
    }
}