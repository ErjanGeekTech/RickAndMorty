package com.example.rickandmorty.common.extensions

import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import java.util.*

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

fun String.capitalized(): String {
    return this.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else it.toString()
    }
}