package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmorty.databinding.ItemCharacterBinding
import com.example.rickandmorty.models.RickAndMortyCharacters

class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    var  list: List<RickAndMortyCharacters> = ArrayList()
    lateinit var binding: ItemCharacterBinding

    fun addList(getList: List<RickAndMortyCharacters>) {
        list = getList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
    class CharacterViewHolder(private val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyCharacters: RickAndMortyCharacters) {
            Glide
                .with(binding.imageItemCharacter)
                .load(rickAndMortyCharacters.image)
                .into(binding.imageItemCharacter)
            binding.textItemCharacter.text = rickAndMortyCharacters.name

        }

    }

}