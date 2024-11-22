package com.vlahovtech.data.di

import com.vlahovtech.data.repository.MockAuthRepositoryImpl
import com.vlahovtech.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun authRepository(impl: MockAuthRepositoryImpl): AuthRepository
}