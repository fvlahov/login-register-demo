package com.vlahovtech.data.networking.apis

import com.vlahovtech.data.networking.model.ApiImageList
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageListApi {

    @GET(".")
    suspend fun getImageList(@Query("page") page: Int, @Query("per_page") pageSize: Int): ApiImageList
}