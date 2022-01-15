package com.example.rickandmorty.presentation.ui.fragments.main.episodes

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentEpisodesBinding
import com.example.rickandmorty.presentation.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>(
    R.layout.fragment_episodes
) {

    override val viewModel: EpisodesViewModel by viewModels()
    private val episodeAdapter: EpisodeAdapter = EpisodeAdapter()
    override val binding by viewBinding(FragmentEpisodesBinding::bind)

    override fun setupViews() {
        setupRecycler()
    }

    override fun setupListeners() {
        setupLoadStateListener()
    }

    override fun setupRequests() {
        fetchLocations()
    }

    private fun setupRecycler() = with(binding.rv) {
        layoutManager = LinearLayoutManager(context)
        adapter = episodeAdapter
    }

    private fun setupLoadStateListener() {
        lifecycleScope.launch {
            episodeAdapter.loadStateFlow.collectLatest { loadStates ->
                binding.episodesProgressBar.isVisible = loadStates.refresh is LoadState.Loading
            }
        }
    }

    private fun fetchLocations() {
        if (verifyAvailableNetwork()) {
            lifecycleScope.launch {
                viewModel.fetchEpisodes().collectLatest(episodeAdapter::submitData)
            }
        }
    }
}