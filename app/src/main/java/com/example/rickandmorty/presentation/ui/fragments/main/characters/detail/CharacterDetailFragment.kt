package com.example.rickandmorty.presentation.ui.fragments.main.characters.detail

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.alish.boilerplate.presentation.state.UIState
import com.example.rickandmorty.R
import com.example.rickandmorty.base.BaseFragment
import com.example.rickandmorty.common.extensions.bindToResourceLoading
import com.example.rickandmorty.common.extensions.bindToResourceNotLoading
import com.example.rickandmorty.common.extensions.setImage
import com.example.rickandmorty.common.extensions.verifyAvailableNetwork
import com.example.rickandmorty.databinding.FragmentDescriptionBinding
import com.example.rickandmorty.presentation.ui.adapters.DetailAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailFragment : BaseFragment<FragmentDescriptionBinding, CharacterDetailViewModel>(
    R.layout.fragment_description
) {
    override val viewModel: CharacterDetailViewModel by viewModels()
    private val args: CharacterDetailFragmentArgs by navArgs()
    override val binding by viewBinding(FragmentDescriptionBinding::bind)

    override fun initialize() {
        if (verifyAvailableNetwork()) {
            viewModel.fetchCharacter(args.id)
        }
    }

    override fun setupViews() {
        setupViewPager()
        setupTabLayout()
    }

    override fun setupListeners() {
        navigationClickBack()
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayoutDetail, binding.viewPagerDetail) { tab, position ->
            tab.text = when (position) {
                0 -> "Episodes"
                1 -> "Locations"
                else -> "Nothing"
            }
        }.attach()
    }

    private fun setupViewPager() {
        binding.viewPagerDetail.adapter = DetailAdapter(this)
    }

    private fun navigationClickBack() {
        binding.mainToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun setupObserves() = with(binding) {
        if (verifyAvailableNetwork()) {
            viewModel.characterState.subscribe {
                binding.loaderDetailCharacter.bindToResourceLoading(it)
                binding.appBar.bindToResourceNotLoading(it)
                binding.showContent.bindToResourceNotLoading(it)
                binding.mainToolbar.bindToResourceNotLoading(it)
                binding.logoCharacter.bindToResourceNotLoading(it)
                when (it) {
                    is UIState.Error -> Log.e("anime", it.error)

                    is UIState.Loading -> Log.e("anime", "loading")

                    is UIState.Success -> {
                        it.data.let { data ->
                            mainToolbar.title = data.name
                            logoCharacter.setImage(data.image)
                            name.text = data.name
                            gender.text = data.gender
                        }
                    }
                }
            }
        }
    }
}