package com.vlahovtech.loginregisterdemo.presentation.home

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vlahovtech.loginregisterdemo.R
import com.vlahovtech.loginregisterdemo.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : BaseViewModel() {

    private val mutableViewState = MutableLiveData<HomeContract.State>()
    val viewState: LiveData<HomeContract.State> = mutableViewState

    private val mutableEffect: Channel<HomeContract.Effect> = Channel()
    val effect = mutableEffect.receiveAsFlow()

    init {
        mutableViewState.postValue(HomeContract.State())
    }

    fun onLoginClicked(email: String, password: String) {
        if (isFormValid(email = email, password = password))
            mutableEffect.trySend(HomeContract.Effect.NavigateToHome)
    }

    private fun isFormValid(email: String, password: String): Boolean {
        val emailError = when {
            email.isBlank() -> R.string.required
            Patterns.EMAIL_ADDRESS.matcher(email).matches().not() -> R.string.email_wrong_format
            else -> null
        }

        val passwordError = when {
            password.isBlank() -> R.string.required
            password.length !in 6..12 -> R.string.password_length_validation
            else -> null
        }

        mutableViewState.update { it.copy(emailError = emailError, passwordError = passwordError) }

        return emailError == null && passwordError == null
    }
}