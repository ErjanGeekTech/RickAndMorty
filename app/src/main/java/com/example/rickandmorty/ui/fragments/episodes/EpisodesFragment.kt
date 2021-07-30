package com.example.rickandmorty.ui.fragments.episodes

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentEpisodesBinding
import com.example.rickandmorty.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>() {
    override val viewModel: EpisodesViewModel by viewModels<EpisodesViewModel>()
    val adapter: EpisodeAdapter = EpisodeAdapter()

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentEpisodesBinding.inflate(inflater, container, false)

    override fun setupRequests() {
        super.setupRequests()
        fetchLocations()
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            viewModel.fetchEpisodes().observe(viewLifecycleOwner, { rickAndMortyEpisodes ->
                binding.progressCircular.setVisibility(View.INVISIBLE)
                if (rickAndMortyEpisodes != null) {
                    adapter.addList(rickAndMortyEpisodes.results)
                }
            })
        } else {
            adapter.addList(viewModel.getEpisodes())
            binding.progressCircular.setVisibility(View.INVISIBLE)
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