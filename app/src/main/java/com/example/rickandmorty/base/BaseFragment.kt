package com.example.rickandmorty.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment <B : ViewBinding, V : ViewModel> : Fragment() {

    protected lateinit var binding: B
    protected lateinit var viewModel: V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)
        viewModel = ViewModelProvider(requireActivity()).get(getViewModel())
        return binding.root
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater,container: ViewGroup?): B
    abstract fun getViewModel(): Class<V>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupRequests()
        setupObserve()
        setupViews()
    }

    open fun setupViews() {

    }

    open fun setupObserve() {}

    open  fun setupRequests() {}

    open fun setupListener() {}

    open fun initialize() {}

}