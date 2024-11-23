package com.vlahovtech.loginregisterdemo.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vlahovtech.domain.use_case.EmailValidationUseCase
import com.vlahovtech.domain.use_case.RegisterUseCase
import com.vlahovtech.loginregisterdemo.R
import com.vlahovtech.loginregisterdemo.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase,
    private val emailValidationUseCase: EmailValidationUseCase
) : BaseViewModel() {

    private val mutableViewState = MutableLiveData<RegisterContract.State>()
    val viewState: LiveData<RegisterContract.State> = mutableViewState

    private val mutableEffect: Channel<RegisterContract.Effect> = Channel()
    val effect = mutableEffect.receiveAsFlow()

    init {
        mutableViewState.postValue(RegisterContract.State())
    }

    fun onRegisterClicked(email: String, password: String, age: Int?) {
        if (isFormValid(email = email, password = password, age = age).not())
            return

        launchWithProgressIn {
            if (registerUseCase.execute(email = email, password = password, age = age!!))
                mutableEffect.trySend(RegisterContract.Effect.NavigateToHome)
            else
                mutableViewState.update {
                    it.copy(emailError = R.string.unknown_error)
                }
        }
    }

    private fun isFormValid(email: String, password: String, age: Int?): Boolean {
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

        val ageError = when (age) {
            null -> R.string.required
            !in 18..99 -> R.string.age_validation
            else -> null
        }

        mutableViewState.update {
            it.copy(
                emailError = emailError,
                passwordError = passwordError,
                ageError = ageError
            )
        }

        return emailError == null && passwordError == null && ageError == null
    }
}