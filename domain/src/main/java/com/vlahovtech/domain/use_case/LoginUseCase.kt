package com.vlahovtech.domain.use_case

import com.vlahovtech.domain.util.IsSuccess

interface LoginUseCase {

    suspend fun execute(email: String, password: String): IsSuccess
}