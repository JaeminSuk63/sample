package com.hyundai.sample.repository.di

import android.content.Context
import com.hyundai.sample.api.Api
import com.hyundai.sample.db.Database
import com.hyundai.sample.repository.dataSource.LocalSource
import com.hyundai.sample.repository.dataSource.LocalSourceImpl
import com.hyundai.sample.repository.dataSource.RemoteSource
import com.hyundai.sample.repository.dataSource.RemoteSourceImpl
import com.hyundai.sample.repository.dataSource.VehicleSource
import com.hyundai.sample.repository.dataSource.VehicleSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    fun provideLocalSource(database: Database): LocalSource =
        LocalSourceImpl(database)

    @Provides
    fun provideRemoteSource(api: Api): RemoteSource = RemoteSourceImpl(api)

    @Provides
    fun provideVehicleSource(@ApplicationContext context: Context): VehicleSource =
        VehicleSourceImpl(context)
}