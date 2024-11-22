package com.vlahovtech.domain.use_case

import com.vlahovtech.domain.util.IsSuccess
import java.time.LocalDate

interface RegisterUseCase {

    suspend fun execute(email: String, password: String, dateOfBirth: LocalDate): IsSuccess
}