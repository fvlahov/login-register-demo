package com.vlahovtech.data.use_case

import com.vlahovtech.domain.repository.AuthRepository
import com.vlahovtech.domain.use_case.LoginUseCase
import com.vlahovtech.domain.util.IsSuccess
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
) : LoginUseCase {

    override suspend fun execute(email: String, password: String): IsSuccess {
        return authRepository.loginWithEmailAndPassword(email, password)
    }
}