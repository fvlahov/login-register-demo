package com.vlahovtech.loginregisterdemo.presentation.image_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vlahovtech.loginregisterdemo.base.BaseViewModel
import com.vlahovtech.loginregisterdemo.model.AppPixabayImage
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@HiltViewModel(assistedFactory = ImageDetailsViewModel.Factory::class)
class ImageDetailsViewModel @AssistedInject constructor(
    @Assisted pixabayImage: AppPixabayImage,
) : BaseViewModel() {

    private val mutableViewState = MutableLiveData<ImageDetailsContract.State>()
    val viewState: LiveData<ImageDetailsContract.State> = mutableViewState

    private val mutableEffect: Channel<ImageDetailsContract.Effect> = Channel()
    val effect = mutableEffect.receiveAsFlow()

    init {
        mutableViewState.postValue(
            ImageDetailsContract.State(
                pixabayImage = pixabayImage
            )
        )
    }

    @AssistedFactory
    interface Factory {
        fun create(pixabayImage: AppPixabayImage): ImageDetailsViewModel
    }
}