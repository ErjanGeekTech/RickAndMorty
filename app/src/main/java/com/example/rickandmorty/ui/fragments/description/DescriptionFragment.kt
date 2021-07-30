package com.example.rickandmorty.ui.fragments.description

import android.content.Context
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.databinding.FragmentDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DescriptionFragment : BaseFragment<FragmentDescriptionBinding, DescriptionViewModel>() {
    override val viewModel: DescriptionViewModel by viewModels<DescriptionViewModel>()
    val args: DescriptionFragmentArgs by navArgs()

     var id: Int? = null

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentDescriptionBinding.inflate(inflater, container, false)

    override fun initialize() {
        super.initialize()
        getIdCharacter()
    }

    private fun getIdCharacter() {
         id = args.getIdCharacter
    }

    override fun setupRequests() {
        super.setupRequests()
        if (verifyAvailableNetwork()) {
            viewModel.getCharacter(id).observe(viewLifecycleOwner, { character ->
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