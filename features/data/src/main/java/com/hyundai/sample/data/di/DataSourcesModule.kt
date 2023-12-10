package com.hyundai.sample.data.di

import android.content.Context
import com.hyundai.sample.data.api.Api
import com.hyundai.sample.data.dataSource.LocalSource
import com.hyundai.sample.data.dataSource.LocalSourceImpl
import com.hyundai.sample.data.dataSource.RemoteSource
import com.hyundai.sample.data.dataSource.RemoteSourceImpl
import com.hyundai.sample.data.dataSource.VehicleSource
import com.hyundai.sample.data.dataSource.VehicleSourceImpl
import com.hyundai.sample.data.db.Database
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