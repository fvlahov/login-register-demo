package com.vlahovtech.domain.model

data class PixabayImage(
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
    val favorites: Int,
    val user: String,
    val type: String,
)