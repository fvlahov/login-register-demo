package com.vlahovtech.data.di

import com.vlahovtech.data.use_case.EmailValidationUseCaseImpl
import com.vlahovtech.data.use_case.LoginUseCaseImpl
import com.vlahovtech.data.use_case.RegisterUseCaseImpl
import com.vlahovtech.domain.use_case.EmailValidationUseCase
import com.vlahovtech.domain.use_case.LoginUseCase
import com.vlahovtech.domain.use_case.RegisterUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun loginUseCase(impl: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun registerUseCase(impl: RegisterUseCaseImpl): RegisterUseCase

    @Binds
    abstract fun emailValidatorUseCase(impl: EmailValidationUseCaseImpl): EmailValidationUseCase
}