package com.vlahovtech.domain.use_case

import com.vlahovtech.domain.util.IsSuccess

interface RegisterUseCase {

    suspend fun execute(email: String, password: String, age: Int): IsSuccess
}