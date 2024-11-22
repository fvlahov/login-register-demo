package com.vlahovtech.loginregisterdemo.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<VS: BaseViewState> : ViewModel() {

    protected val mutableViewState: MutableLiveData<VS> = MutableLiveData()
    val viewState: LiveData<VS> = mutableViewState

    protected fun launchIn(
        coroutineScope: CoroutineScope = viewModelScope,
        action: suspend () -> Unit
    ) {
        coroutineScope.launch {
            action()
        }
    }
}