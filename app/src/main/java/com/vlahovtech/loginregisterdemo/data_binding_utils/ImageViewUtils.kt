package com.vlahovtech.loginregisterdemo.data_binding_utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:glide")
fun ImageView.setImageUrl(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}