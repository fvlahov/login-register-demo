package com.vlahovtech.domain.use_case

interface AuthTokenUseCase {

    suspend fun isAuthTokenValid(): Boolean

    suspend fun saveAuthToken(token: String)
}