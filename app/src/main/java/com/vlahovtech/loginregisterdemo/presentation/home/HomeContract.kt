package com.vlahovtech.loginregisterdemo.presentation.home

import androidx.annotation.StringRes
import com.vlahovtech.loginregisterdemo.base.BaseEffect
import com.vlahovtech.loginregisterdemo.base.BaseViewState

interface HomeContract {
    data class State(
        @StringRes val emailError: Int? = null,
        @StringRes val passwordError: Int? = null,
    ): BaseViewState

    sealed interface Effect : BaseEffect {
        data object NavigateToHome: Effect
    }
}