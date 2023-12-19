package com.hyundai.sample.usecase.di

import com.hyundai.sample.usecase.SampleRepository
import com.hyundai.sample.usecase.SampleUseCase
import com.hyundai.sample.usecase.cloud.GetApiVersion
import com.hyundai.sample.usecase.searchhistory.AddSearchHistory
import com.hyundai.sample.usecase.searchhistory.DeleteSearchHistory
import com.hyundai.sample.usecase.searchhistory.GetSearchHistory
import com.hyundai.sample.usecase.vehicle.GetIgnitionState
import com.hyundai.sample.usecase.vehicle.IsParkingBrakeOn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUseCase(repository: SampleRepository) =
        SampleUseCase(
            addSearchHistory = AddSearchHistory(repository),
            deleteSearchHistory = DeleteSearchHistory(repository),
            getApiVersion = GetApiVersion(repository),
            getIgnitionState = GetIgnitionState(repository),
            getSearchHistory = GetSearchHistory(repository),
            isParkingBrakeOn = IsParkingBrakeOn(repository),
        )
}