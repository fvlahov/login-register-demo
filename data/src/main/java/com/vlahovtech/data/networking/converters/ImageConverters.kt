package com.vlahovtech.data.networking.converters

import com.vlahovtech.data.networking.model.ApiImage
import com.vlahovtech.data.networking.model.ApiImageList
import com.vlahovtech.domain.model.Page
import com.vlahovtech.domain.model.PixabayImage

fun ApiImageList.toPage(currentPage: Int) = Page(
    currentPage = currentPage,
    totalItems = totalHits,
    items = images.map { it.toPixabayImage() }
)

fun ApiImage.toPixabayImage() = PixabayImage(
    id = id,
    tags = tags,
    previewUrl = previewUrl,
    imageUrl = imageUrl,
    imageWidth = imageWidth,
    imageHeight = imageHeight,
    views = views,
    favorites = favorites,
    downloads = downloads,
    likes = likes,
    comments = comments,
    user = user,
    type = type
)