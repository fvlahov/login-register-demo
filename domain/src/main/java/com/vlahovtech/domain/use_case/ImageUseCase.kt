package com.vlahovtech.domain.use_case

import androidx.paging.PagingData
import com.vlahovtech.domain.model.PixabayImage
import kotlinx.coroutines.flow.Flow

interface ImageUseCase {
    fun getImagesPagingDataFlow(): Flow<PagingData<PixabayImage>>
}