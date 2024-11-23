package com.vlahovtech.loginregisterdemo.presentation.image_details

import com.vlahovtech.loginregisterdemo.base.BaseEffect
import com.vlahovtech.loginregisterdemo.base.BaseViewState
import com.vlahovtech.loginregisterdemo.model.AppPixabayImage

interface ImageDetailsContract {
    data class State(
        val pixabayImage: AppPixabayImage
    ): BaseViewState

    sealed interface Effect : BaseEffect
}