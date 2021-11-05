package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.base.BaseDiffUtilItemCallback
import com.example.rickandmorty.databinding.ItemLocationBinding
import com.example.rickandmorty.models.RickAndMortyLocations

class LocationAdapter : PagingDataAdapter<RickAndMortyLocations, LocationAdapter.LocationViewHolder>(
        BaseDiffUtilItemCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(rickAndMortyLocations: RickAndMortyLocations) {
            binding.txtNameLocation.text = rickAndMortyLocations.name
            binding.typeLocationTxt.text = rickAndMortyLocations.type
            binding.txtDimensionLocation.text = rickAndMortyLocations.dimension
            binding.txtCreatedLocation.text = rickAndMortyLocations.created
        }
    }
}