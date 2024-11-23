package com.vlahovtech.data.networking

import okhttp3.Interceptor
import okhttp3.Response


class PixabayKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("key", "47239647-393565ba96ecbfa6584b7e46f")
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        val response = chain.proceed(request)
        return response
    }

}