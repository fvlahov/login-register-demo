package com.vlahovtech.data.networking.model

import com.google.gson.annotations.SerializedName

data class ApiImage(
    @SerializedName("id") val id: Int,
    @SerializedName("tags") val tags: String,
    @SerializedName("previewURL") val previewUrl: String,
    @SerializedName("imageURL") val imageUrl: String?,
    @SerializedName("imageWidth") val imageWidth: Int,
    @SerializedName("imageHeight") val imageHeight: Int,
    @SerializedName("views") val views: Int,
    @SerializedName("downloads") val downloads: Int,
    @SerializedName("likes") val likes: Int,
    @SerializedName("comments") val comments: Int,
    @SerializedName("user") val user: String,

)