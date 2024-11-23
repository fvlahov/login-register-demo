package com.vlahovtech.domain.repository

import com.vlahovtech.domain.model.Page
import com.vlahovtech.domain.model.PixabayImage

interface ImageRepository {

    suspend fun getImageList(page: Int, pageSize: Int): Page<PixabayImage>
}