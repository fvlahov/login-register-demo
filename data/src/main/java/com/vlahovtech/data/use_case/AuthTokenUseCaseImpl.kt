package com.vlahovtech.data.use_case

import com.vlahovtech.domain.repository.PreferencesRepository
import com.vlahovtech.domain.use_case.AuthTokenUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthTokenUseCaseImpl @Inject constructor(
    private val preferencesRepository: PreferencesRepository
): AuthTokenUseCase {

    override suspend fun isAuthTokenValid(): Boolean = withContext(Dispatchers.IO) {
        return@withContext preferencesRepository.authToken != null
    }

    override suspend fun saveAuthToken(token: String) = withContext(Dispatchers.IO) {
        preferencesRepository.authToken = token
    }
}