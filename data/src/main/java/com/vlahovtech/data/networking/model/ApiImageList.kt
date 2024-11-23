package com.vlahovtech.data.networking.model

import com.google.gson.annotations.SerializedName

data class ApiImageList(
    @SerializedName("total") val total: Int,
    @SerializedName("totalHits") val totalHits: Int,
    @SerializedName("hits") val images: List<ApiImage>,
)
