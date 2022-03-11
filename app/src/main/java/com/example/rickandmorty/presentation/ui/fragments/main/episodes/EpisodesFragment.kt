package com.example.rickandmorty.presentation.ui.fragments.main.episodes

import android.util.Log
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.isConnectedOrConnecting
import com.example.rickandmorty.common.extensions.submitData
import com.example.rickandmorty.databinding.FragmentEpisodesBinding
import com.example.rickandmorty.presentation.ui.adapters.EpisodeAdapter
import com.example.rickandmorty.utils.PaginationScrollListener
import dagger.hilt.android.AndroidEntryPoint

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

    override fun setupRequests() {
        if (episodeAdapter.currentList.isEmpty()) viewModel.fetchEpisodes()
    }

    override fun setupObserves() {
        fetchEpisodes()
    }

    private fun setupRecycler() = with(binding.rv) {
        val linearLayoutManager = LinearLayoutManager(context)
        layoutManager = linearLayoutManager
        adapter = episodeAdapter

        addOnScrollListener(object : PaginationScrollListener(linearLayoutManager, { viewModel.fetchEpisodes() }) {
            override fun isLoading() = viewModel.isLoading
        })
    }

    private fun fetchEpisodes() {
        if (isConnectedOrConnecting()) {
            viewModel.episodesState.subscribe {
                when (it) {
                    is UIState.Loading -> {

                    }
                    is UIState.Error -> {
                        Log.e("anime", it.error)
                    }
                    is UIState.Success -> {
                        binding.episodesProgressBar.isVisible = false
                        episodeAdapter.submitData(it.data)
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