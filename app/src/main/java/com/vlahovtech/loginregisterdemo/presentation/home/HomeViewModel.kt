package com.vlahovtech.loginregisterdemo.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.vlahovtech.domain.use_case.ImageUseCase
import com.vlahovtech.loginregisterdemo.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    imageUseCase: ImageUseCase
) : BaseViewModel() {

    private val mutableViewState = MutableLiveData<HomeContract.State>()
    val viewState: LiveData<HomeContract.State> = mutableViewState

    private val mutableEffect: Channel<HomeContract.Effect> = Channel()
    val effect = mutableEffect.receiveAsFlow()

    val imagesPagingDataFlow = imageUseCase.getImagesPagingDataFlow()
        .cachedIn(viewModelScope)

    init {
        mutableViewState.postValue(HomeContract.State())
    }
}