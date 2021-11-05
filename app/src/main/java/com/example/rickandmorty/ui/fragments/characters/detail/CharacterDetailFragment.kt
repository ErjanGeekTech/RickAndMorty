package com.example.rickandmorty.ui.fragments.characters.detail

import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.setImage
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentDescriptionBinding
import com.example.rickandmorty.ui.fragments.characters.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CharacterDetailFragment : BaseFragment<FragmentDescriptionBinding, CharacterViewModel>(
    R.layout.fragment_description
) {
    override val viewModel: CharacterViewModel by sharedViewModel()
    private val args: CharacterDetailFragmentArgs by navArgs()
    override val binding by viewBinding(FragmentDescriptionBinding::bind)

    override fun setupRequests() {
        if (verifyAvailableNetwork()) {
            viewModel.getCharacter(args.id).observe(viewLifecycleOwner, { character ->
                with(binding) {
                    imageDescription.setImage(character.image)
                    textNameDescription.text = character.name
                }
            })
        }
    }
}