package com.vlahovtech.data.use_case

import android.util.Patterns
import com.vlahovtech.domain.use_case.EmailValidationUseCase
import javax.inject.Inject

class EmailValidationUseCaseImpl @Inject constructor(): EmailValidationUseCase {
    override fun isValid(input: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }
}