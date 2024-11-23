package com.vlahovtech.data.repository

import com.vlahovtech.domain.repository.AuthRepository
import com.vlahovtech.domain.util.IsSuccess
import javax.inject.Inject

class MockAuthRepositoryImpl @Inject constructor(): AuthRepository {

    override suspend fun signUpWithEmailAndPassword(
        email: String,
        password: String,
        dateOfBirth: Int,
    ): IsSuccess {
        return true
    }

    override suspend fun loginWithEmailAndPassword(email: String, password: String): IsSuccess {
        return email == "test@test.com" && password == "123456"
    }
}