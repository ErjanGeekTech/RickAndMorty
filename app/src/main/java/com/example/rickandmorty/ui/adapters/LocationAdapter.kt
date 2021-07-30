package com.example.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmorty.databinding.ItemLocationBinding
import com.example.rickandmorty.models.RickAndMortyLocations

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    var list: List<RickAndMortyLocations> = ArrayList()
    lateinit var binding: ItemLocationBinding

    fun addList(getList: List<RickAndMortyLocations>) {
        list = getList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class LocationViewHolder(val binding: ItemLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(rickAndMortyLocations: RickAndMortyLocations) {
            binding.txtNameLocation.text = rickAndMortyLocations.name
            binding.typeLocationTxt.text = rickAndMortyLocations.type
            binding.txtDimensionLocation.text = rickAndMortyLocations.dimension
            binding.txtCreatedLocation.text = rickAndMortyLocations.created
        }

    }
}