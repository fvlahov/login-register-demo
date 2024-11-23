package com.vlahovtech.data.di

import com.vlahovtech.data.repository.ImageRepositoryImpl
import com.vlahovtech.data.repository.MockAuthRepositoryImpl
import com.vlahovtech.domain.repository.AuthRepository
import com.vlahovtech.domain.repository.ImageRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun authRepository(impl: MockAuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun imageRepository(impl: ImageRepositoryImpl): ImageRepository
}