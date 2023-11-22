package com.hyundai.sample.core.di

import com.hyundai.sample.core.data.dataSources.LocalSource
import com.hyundai.sample.core.data.dataSources.RemoteSource
import com.hyundai.sample.core.data.dataSources.VehicleSource
import com.hyundai.sample.core.data.repository.Repository
import com.hyundai.sample.core.data.repository.RepositoryImpl
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
    ): Repository =
        RepositoryImpl(localSource, remoteSource, vehicleSource)
}