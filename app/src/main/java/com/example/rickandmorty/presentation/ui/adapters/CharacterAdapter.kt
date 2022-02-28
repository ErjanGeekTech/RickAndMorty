package com.example.rickandmorty.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseDiffUtilItemCallback
import com.example.rickandmorty.common.extensions.capitalized
import com.example.rickandmorty.common.extensions.setImage
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.presentation.models.RickAndMortyCharacterUI

class CharacterAdapter(
    val onItemClick: (id: Int) -> Unit,
    val doRequestEpisode: (episode: String, position: Int) -> Unit
) :
    ListAdapter<RickAndMortyCharacterUI, CharacterAdapter.CharacterViewHolder>(
        BaseDiffUtilItemCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    fun firstSeenIn(episode: String, position: Int) {
        getItem(position)?.firstEpisode = episode
        notifyItemChanged(position, true)
    }

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemClick(id) }
            }
        }

        fun onBind(rickAndMortyCharacters: RickAndMortyCharacterUI) = with(binding) {
            imageItemCharacter.setImage(rickAndMortyCharacters.image)
            nameCharacter.text = rickAndMortyCharacters.name
            when (rickAndMortyCharacters.status) {
                "Alive" -> icStatusCharacter.setImageResource(R.drawable.status_alive_circle)

                "Dead" -> icStatusCharacter.setImageResource(R.drawable.status_dead_circle)

                "unknown" -> icStatusCharacter.setImageResource(R.drawable.status_unknown_circle)
            }
            speciesCharacter.text =
                "${rickAndMortyCharacters.status.capitalized()} - ${rickAndMortyCharacters.species}"

            lastKnowLocation.text = rickAndMortyCharacters.location.name.capitalized()
            firstSeenIn(rickAndMortyCharacters.firstEpisode, rickAndMortyCharacters.episode[0])
        }

        private fun firstSeenIn(firstEpisode: String?, episode: String) {
            binding.progressBarEpisode.isVisible = firstEpisode == null
            binding.firstSeenIn.text = ""
            if (firstEpisode == null) doRequestEpisode(episode, absoluteAdapterPosition)
            else binding.firstSeenIn.text = firstEpisode
        }
    }
}