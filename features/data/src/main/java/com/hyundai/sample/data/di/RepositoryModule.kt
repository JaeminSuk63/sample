package com.hyundai.sample.data.di

import com.hyundai.sample.data.dataSource.LocalSource
import com.hyundai.sample.data.dataSource.RemoteSource
import com.hyundai.sample.data.dataSource.VehicleSource
import com.hyundai.sample.data.repository.Repository
import com.hyundai.sample.data.repository.RepositoryImpl
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