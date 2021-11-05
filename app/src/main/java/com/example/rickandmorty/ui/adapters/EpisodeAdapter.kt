package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.base.BaseDiffUtilItemCallback
import com.example.rickandmorty.databinding.ItemEpisodeBinding
import com.example.rickandmorty.models.RickAndMortyEpisodes

class EpisodeAdapter : PagingDataAdapter<RickAndMortyEpisodes, EpisodeAdapter.EpisodeViewHolder>(
    BaseDiffUtilItemCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(rickAndMortyEpisodes: RickAndMortyEpisodes) {
            binding.txtNameEpisodes.text = rickAndMortyEpisodes.name
            binding.txtAirDateEpisodes.text = rickAndMortyEpisodes.airDate
            binding.txtEpisodesEpisodes.text = rickAndMortyEpisodes.episode
            binding.txtCreatedEpisodes.text = rickAndMortyEpisodes.created
        }
    }
}