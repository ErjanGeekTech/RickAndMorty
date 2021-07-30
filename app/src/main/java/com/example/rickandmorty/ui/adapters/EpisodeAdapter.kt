package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemEpisodeBinding
import com.example.rickandmorty.models.RickAndMortyEpisodes

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    var list: List<RickAndMortyEpisodes> = ArrayList()
    lateinit var binding: ItemEpisodeBinding

    fun addList(getList: List<RickAndMortyEpisodes>){
        list = getList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
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