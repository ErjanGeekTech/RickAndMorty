package com.example.rickandmorty.presentation.ui.fragments.main.characters.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.setImage
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentDescriptionBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : BaseFragment<FragmentDescriptionBinding, CharacterDetailViewModel>(
    R.layout.fragment_description
) {
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()
    override val binding by viewBinding(FragmentDescriptionBinding::bind)

    override fun initialize() {
        viewModel.fetchCharacter(args.id)
    }

    override fun setupObserves() = with(binding) {
        if (verifyAvailableNetwork()) {
            viewModel.characterState.subscribe {
                when (it) {
                    is UIState.Error -> Log.e("anime", it.error)

                    is UIState.Loading -> Log.e("anime", "loading")

                    is UIState.Success -> {
                        it.data.let { data ->
                            mainBackdrop.setImage(data.image)
                            name.text = data.name
                            gender.text = data.gender
                        }
                    }
                }
            }
        }
    }
}