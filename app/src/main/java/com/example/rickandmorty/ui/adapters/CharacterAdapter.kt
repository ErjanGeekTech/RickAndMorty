package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.base.BaseDiffUtilItemCallback
import com.example.rickandmorty.common.extensions.setImage
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.models.RickAndMortyCharacters

class CharacterAdapter(val onItemClick: (id: Int) -> Unit) :
    PagingDataAdapter<RickAndMortyCharacters, CharacterAdapter.CharacterViewHolder>(
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

    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                getItem(absoluteAdapterPosition)?.apply { onItemClick(id) }
            }
        }

        fun onBind(rickAndMortyCharacters: RickAndMortyCharacters) = with(binding) {
            imageItemCharacter.setImage(rickAndMortyCharacters.image)
            textItemCharacter.text = rickAndMortyCharacters.name
        }
    }
}