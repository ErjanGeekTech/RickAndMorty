package com.example.rickandmorty.ui.fragments.description

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentDescriptionBinding
import com.example.rickandmorty.ui.fragments.characters.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DescriptionFragment : BaseFragment<FragmentDescriptionBinding, CharacterViewModel>(
    R.layout.fragment_description
) {
    override val viewModel: CharacterViewModel by sharedViewModel()
    val args: DescriptionFragmentArgs by navArgs()
    override val binding by viewBinding(FragmentDescriptionBinding::bind)


    override fun setupRequests() {
        super.setupRequests()
        if (verifyAvailableNetwork()) {
            viewModel.getCharacter(args.getIdCharacter).observe(viewLifecycleOwner, { character ->
                Glide.with(binding.imageDescription)
                    .load(character.image)
                    .into(binding.imageDescription)
                binding.textNameDescription.text = character.name
            })
        }

    }

    fun verifyAvailableNetwork(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }




}