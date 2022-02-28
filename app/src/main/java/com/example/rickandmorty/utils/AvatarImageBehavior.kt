package com.example.rickandmorty.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.Toolbar
import androidx.coordinatorlayout.widget.CoordinatorLayout

class AvatarImageBehavior() : CoordinatorLayout.Behavior<ImageView>() {

    constructor(ctx: Context, attrs: AttributeSet) : this()

    override fun layoutDependsOn(
        parent: CoordinatorLayout,
        child: ImageView,
        dependency: View
    ): Boolean {
        return dependency is Toolbar
    }

    override fun onDependentViewChanged(
        parent: CoordinatorLayout,
        child: ImageView,
        dependency: View
    ): Boolean {
        modifyAvatarDependingDependencyState(child, dependency);

        return super.onDependentViewChanged(parent, child, dependency)
    }

    private fun modifyAvatarDependingDependencyState(
        avatar: ImageView, dependency: View
    ) {
        avatar.y = dependency.y
//        avatar.bl(dependency.blah / blah);
    }
}