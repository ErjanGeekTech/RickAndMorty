package com.example.rickandmorty.ui.fragments.locations

import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentLocationsBinding
import com.example.rickandmorty.ui.adapters.LocationAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<FragmentLocationsBinding, LocationsViewModel>(
    R.layout.fragment_locations
) {
    override val viewModel: LocationsViewModel by viewModel()
    val locationAdapter: LocationAdapter = LocationAdapter()
    override val binding by viewBinding(FragmentLocationsBinding::bind)



    override fun setupRequests() {
        super.setupRequests()
        fetchLocations()
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchLocations().collectLatest {
                    locationAdapter.submitData(it)
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

    override fun setupViews() {
        super.setupViews()
        setupRecycler()
    }

    private fun setupRecycler() {
        binding.rv.apply{
            layoutManager = LinearLayoutManager(context)
            adapter = locationAdapter
        }
        binding.rv.layoutManager = LinearLayoutManager(context)
        binding.rv.adapter = locationAdapter
    }


}