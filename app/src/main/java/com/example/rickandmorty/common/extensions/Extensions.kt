package com.example.rickandmorty.common.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun Fragment.verifyAvailableNetwork(): Boolean {
    val connectivityManager =
        requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val netInfo = connectivityManager.activeNetworkInfo
    return netInfo != null && netInfo.isConnected
}

fun ImageView.setImage(url: String) =
    Glide.with(this)
        .load(url)
        .into(this)