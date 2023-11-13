package com.hyundai.sample.core.di

import android.content.Context
import com.hyundai.sample.core.data.api.Api
import com.hyundai.sample.core.data.dataSources.LocalSource
import com.hyundai.sample.core.data.dataSources.LocalSourceImpl
import com.hyundai.sample.core.data.dataSources.RemoteSource
import com.hyundai.sample.core.data.dataSources.RemoteSourceImpl
import com.hyundai.sample.core.data.dataSources.VehicleSource
import com.hyundai.sample.core.data.dataSources.VehicleSourceImpl
import com.hyundai.sample.core.data.db.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataSourcesModule {

    @Provides
    fun provideLocalSource(database: Database): LocalSource = LocalSourceImpl(database)

    @Provides
    fun provideRemoteSource(api: Api): RemoteSource = RemoteSourceImpl(api)

    @Provides
    fun provideVehicleSource(@ApplicationContext context: Context): VehicleSource =
        VehicleSourceImpl(context)
}