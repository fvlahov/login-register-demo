package com.vlahovtech.domain.use_case

interface EmailValidationUseCase {
    fun isValid(input: String): Boolean
}