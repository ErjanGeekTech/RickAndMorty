package com.example.rickandmorty.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.alish.boilerplate.presentation.state.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<B :  ViewBinding, V : BaseViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    protected abstract val binding: B
    protected abstract val viewModel: V

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupViews()
        setupListeners()
        setupRequests()
        setupObserves()
    }

    open fun setupViews() {
    }

    open fun setupObserves() {
    }

    open fun setupRequests() {
    }

    open fun setupListeners() {
    }

    open fun initialize() {
    }

    protected fun <T> StateFlow<UIState<T>>.subscribe(
        state: Lifecycle.State = Lifecycle.State.STARTED,
        action: (UIState<T>) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(state) {
                this@subscribe.collect {
                    action(it)
                }
            }
        }
    }
}