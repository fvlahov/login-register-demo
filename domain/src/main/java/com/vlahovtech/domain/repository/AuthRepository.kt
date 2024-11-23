package com.vlahovtech.domain.repository

import com.vlahovtech.domain.util.IsSuccess

interface AuthRepository {
    suspend fun signUpWithEmailAndPassword(email: String, password: String, dateOfBirth: Int): IsSuccess

    suspend fun loginWithEmailAndPassword(email: String, password: String): IsSuccess
}