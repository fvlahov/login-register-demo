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
    val views: String,
    val downloads: String,
    val likes: String,
    val comments: String,
    val favorites: String,
    val user: String,
    val type: String,
) : Parcelable {
    val imageSize: String
        get() = "$imageWidth x $imageHeight"
}

fun PixabayImage.toAppPixabayImage() = AppPixabayImage(
    id = id,
    tags = tags,
    previewUrl = previewUrl,
    imageUrl = imageUrl,
    imageWidth = imageWidth,
    imageHeight = imageHeight,
    views = views.toString(),
    downloads = downloads.toString(),
    likes = likes.toString(),
    comments = comments.toString(),
    favorites = favorites.toString(),
    user = user,
    type = type
)
