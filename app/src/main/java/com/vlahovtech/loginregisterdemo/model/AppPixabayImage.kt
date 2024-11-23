package com.vlahovtech.loginregisterdemo.model

import android.os.Parcelable
import com.vlahovtech.domain.model.PixabayImage
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppPixabayImage(
    val id: Int,
    val tags: String,
    val previewUrl: String,
    val imageUrl: String?,
    val imageWidth: Int,
    val imageHeight: Int,
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user: String,
): Parcelable

fun PixabayImage.toAppPixabayImage() = AppPixabayImage(
    id = id,
    tags = tags,
    previewUrl = previewUrl,
    imageUrl = imageUrl,
    imageWidth = imageWidth,
    imageHeight = imageHeight,
    views = views,
    downloads = downloads,
    likes = likes,
    comments = comments,
    user = user
)
