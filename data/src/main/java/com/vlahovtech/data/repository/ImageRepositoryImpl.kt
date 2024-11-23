package com.vlahovtech.data.repository

import com.vlahovtech.data.networking.apis.ImageListApi
import com.vlahovtech.data.networking.converters.toPage
import com.vlahovtech.domain.model.Page
import com.vlahovtech.domain.model.PixabayImage
import com.vlahovtech.domain.repository.ImageRepository
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageListApi: ImageListApi
): ImageRepository {

    override suspend fun getImageList(page: Int, pageSize: Int): Page<PixabayImage> {
        return imageListApi.getImageList(page = page, pageSize = pageSize).toPage(currentPage = page)
    }
}