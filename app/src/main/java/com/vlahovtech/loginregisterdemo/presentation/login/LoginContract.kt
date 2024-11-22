package com.vlahovtech.loginregisterdemo.presentation.login

import androidx.annotation.StringRes
import com.vlahovtech.loginregisterdemo.base.BaseEffect
import com.vlahovtech.loginregisterdemo.base.BaseViewState

interface LoginContract {
    data class State(
        @StringRes val emailError: Int? = null,
        @StringRes val passwordError: Int? = null,
    ): BaseViewState

    sealed interface Effect : BaseEffect {
        data object NavigateToHome: Effect
    }
}