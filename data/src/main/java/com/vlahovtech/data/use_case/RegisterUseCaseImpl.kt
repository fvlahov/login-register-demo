package com.vlahovtech.data.use_case

import com.vlahovtech.domain.repository.AuthRepository
import com.vlahovtech.domain.use_case.RegisterUseCase
import com.vlahovtech.domain.util.IsSuccess
import javax.inject.Inject

class RegisterUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository
) : RegisterUseCase {

    override suspend fun execute(email: String, password: String, age: Int): IsSuccess {
        return authRepository.signUpWithEmailAndPassword(email, password, age)
    }
}