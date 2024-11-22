package com.vlahovtech.loginregisterdemo.presentation.register

import androidx.annotation.StringRes
import com.vlahovtech.loginregisterdemo.base.BaseEffect
import com.vlahovtech.loginregisterdemo.base.BaseViewState

interface RegisterContract {
    data class State(
        @StringRes val emailError: Int? = null,
        @StringRes val passwordError: Int? = null,
        @StringRes val ageError: Int? = null,
    ): BaseViewState

    sealed interface Effect : BaseEffect {
        data object NavigateToHome: Effect
    }
}