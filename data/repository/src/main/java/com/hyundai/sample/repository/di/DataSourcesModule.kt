package com.hyundai.sample.repository.di

import android.content.Context
import com.hyundai.sample.api.Api
import com.hyundai.sample.db.Database
import com.hyundai.sample.repository.datasource.LocalSource
import com.hyundai.sample.repository.datasource.LocalSourceImpl
import com.hyundai.sample.repository.datasource.RemoteSource
import com.hyundai.sample.repository.datasource.RemoteSourceImpl
import com.hyundai.sample.repository.datasource.VehicleSource
import com.hyundai.sample.repository.datasource.VehicleSourceImpl
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