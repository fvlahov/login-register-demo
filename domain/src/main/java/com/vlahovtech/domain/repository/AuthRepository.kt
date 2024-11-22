package com.vlahovtech.domain.repository

import com.vlahovtech.domain.util.IsSuccess
import java.time.LocalDate

interface AuthRepository {
    suspend fun signUpWithEmailAndPassword(email: String, password: String, dateOfBirth: LocalDate): IsSuccess

    suspend fun loginWithEmailAndPassword(email: String, password: String): IsSuccess
}