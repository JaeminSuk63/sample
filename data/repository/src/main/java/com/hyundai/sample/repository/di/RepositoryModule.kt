package com.hyundai.sample.repository.di

import com.hyundai.sample.repository.Repository
import com.hyundai.sample.repository.RepositoryImpl
import com.hyundai.sample.repository.dataSource.LocalSource
import com.hyundai.sample.repository.dataSource.RemoteSource
import com.hyundai.sample.repository.dataSource.VehicleSource
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