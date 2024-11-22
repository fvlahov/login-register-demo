package com.vlahovtech.data.use_case

import com.vlahovtech.domain.repository.AuthRepository
import com.vlahovtech.domain.use_case.RegisterUseCase
import com.vlahovtech.domain.util.IsSuccess
import java.time.LocalDate
import javax.inject.Inject

class RegisterUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : RegisterUseCase {

    override suspend fun execute(email: String, password: String, dateOfBirth: LocalDate): IsSuccess {
        return authRepository.signUpWithEmailAndPassword(email, password, dateOfBirth)
    }
}