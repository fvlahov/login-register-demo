package com.vlahovtech.loginregisterdemo.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun launchIn(
        coroutineScope: CoroutineScope = viewModelScope,
        action: suspend () -> Unit
    ) {
        coroutineScope.launch {
            action()
        }
    }

    protected fun launchWithProgressIn(
        coroutineScope: CoroutineScope = viewModelScope,
        onStart: () -> Unit = {},
        onFinish: () -> Unit = {},
        action: suspend () -> Unit
    ) {
        launchIn(
            coroutineScope = coroutineScope
        ) {
            onStart()
            action()
            onFinish()
        }
    }

    protected fun <T: BaseViewState> MutableLiveData<T>.update(transform: (T) -> T) {
        val currentValue = this.value
        require(currentValue != null) { "View state live data value cannot be null!" }

        this.value = transform(currentValue)
    }
}