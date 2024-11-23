package com.vlahovtech.data.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.vlahovtech.data.paging.DefaultPagingSource
import com.vlahovtech.domain.model.PixabayImage
import com.vlahovtech.domain.repository.ImageRepository
import com.vlahovtech.domain.use_case.ImageUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ImageUseCaseImpl @Inject constructor(
    private val imageRepository: ImageRepository,
) : ImageUseCase {
    override fun getImagesPagingDataFlow(): Flow<PagingData<PixabayImage>> =
        Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = {
                DefaultPagingSource { page, pageSize ->
                    imageRepository.getImageList(page = page, pageSize = pageSize)
                }
            }
        ).flow
}