package com.example.rickandmorty.ui.fragments.episodes

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentEpisodesBinding
import com.example.rickandmorty.ui.adapters.EpisodeAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>(
    R.layout.fragment_episodes
) {

    override val viewModel: EpisodesViewModel by viewModel()
    private val episodeAdapter: EpisodeAdapter = EpisodeAdapter()
    override val binding by viewBinding(FragmentEpisodesBinding::bind)

    override fun setupRequests() {
        fetchLocations()
    }

    override fun setupViews() {
        setupRecycler()
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchEpisodes().collectLatest(episodeAdapter::submitData)
            }
        }
    }

    private fun setupRecycler() = with(binding.rv) {
        layoutManager = LinearLayoutManager(context)
        adapter = episodeAdapter
    }
}