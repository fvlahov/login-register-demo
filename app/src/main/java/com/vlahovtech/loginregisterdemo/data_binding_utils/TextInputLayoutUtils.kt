package com.vlahovtech.loginregisterdemo.data_binding_utils

import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:errorText")
fun TextInputLayout.setErrorMessage(errorMessage: String?) {
    error = errorMessage
}

@BindingAdapter("app:errorText")
fun TextInputLayout.setErrorMessage(@StringRes errorRes: Int?) {
    error = errorRes?.let { context.getString(it) }
}