package com.example.rickandmorty.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.rickandmorty.presentation.ui.fragments.main.episodes.EpisodesFragment
import com.example.rickandmorty.presentation.ui.fragments.main.locations.LocationsFragment

class DetailAdapter(fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> {
                LocationsFragment()
            }
            else -> EpisodesFragment()
        }
    }
}