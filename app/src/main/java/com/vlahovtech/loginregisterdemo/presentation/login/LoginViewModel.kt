package com.vlahovtech.loginregisterdemo.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vlahovtech.domain.use_case.EmailValidationUseCase
import com.vlahovtech.domain.use_case.LoginUseCase
import com.vlahovtech.loginregisterdemo.R
import com.vlahovtech.loginregisterdemo.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val emailValidationUseCase: EmailValidationUseCase,
) : BaseViewModel() {

    private val mutableViewState = MutableLiveData<LoginContract.State>()
    val viewState: LiveData<LoginContract.State> = mutableViewState

    private val mutableEffect: Channel<LoginContract.Effect> = Channel()
    val effect = mutableEffect.receiveAsFlow()

    init {
        mutableViewState.postValue(LoginContract.State())
    }

    fun onLoginClicked(email: String, password: String) {
        if (isFormValid(email = email, password = password).not())
            return

        launchWithProgressIn {
            if (loginUseCase.execute(email = email, password = password))
                mutableEffect.trySend(LoginContract.Effect.NavigateToHome)
            else
                mutableViewState.update {
                    it.copy(emailError = R.string.wrong_email_password_combination)
                }
        }
    }

    private fun isFormValid(email: String, password: String): Boolean {
        val emailError = when {
            email.isBlank() -> R.string.required
            emailValidationUseCase.isValid(email).not() -> R.string.email_wrong_format
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