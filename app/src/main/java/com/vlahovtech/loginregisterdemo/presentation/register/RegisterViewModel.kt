package com.vlahovtech.loginregisterdemo.presentation.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vlahovtech.loginregisterdemo.base.BaseViewModel
import com.vlahovtech.loginregisterdemo.presentation.login.LoginContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : BaseViewModel() {

    private val mutableViewState = MutableLiveData<RegisterContract.State>()
    val viewState: LiveData<RegisterContract.State> = mutableViewState

    private val mutableEffect: Channel<RegisterContract.Effect> = Channel()
    val effect = mutableEffect.receiveAsFlow()

    fun onLoginClicked() {

    }
}