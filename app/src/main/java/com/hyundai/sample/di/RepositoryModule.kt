package com.hyundai.sample.di

import com.hyundai.sample.repository.SampleRepositoryImpl
import com.hyundai.sample.repository.datasource.LocalSource
import com.hyundai.sample.repository.datasource.RemoteSource
import com.hyundai.sample.repository.datasource.VehicleSource
import com.hyundai.sample.usecase.SampleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        localSource: LocalSource,
        remoteSource: RemoteSource,
        vehicleSource: VehicleSource
    ): SampleRepository = SampleRepositoryImpl(localSource, remoteSource, vehicleSource)
}