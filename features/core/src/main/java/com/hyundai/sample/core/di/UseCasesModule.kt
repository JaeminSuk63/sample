package com.hyundai.sample.core.di

import com.hyundai.sample.core.data.repository.Repository
import com.hyundai.sample.core.domain.UseCases
import com.hyundai.sample.core.domain.useCases.AddSearchHistory
import com.hyundai.sample.core.domain.useCases.DeleteSearchHistory
import com.hyundai.sample.core.domain.useCases.GetApiVersion
import com.hyundai.sample.core.domain.useCases.GetIgnitionState
import com.hyundai.sample.core.domain.useCases.GetSearchHistory
import com.hyundai.sample.core.domain.useCases.IsParkingBrakeOn
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideUseCases(repository: Repository) = UseCases(
        addSearchHistory = AddSearchHistory(repository),
        deleteSearchHistory = DeleteSearchHistory(repository),
        getApiVersion = GetApiVersion(repository),
        getIgnitionState = GetIgnitionState(repository),
        getSearchHistory = GetSearchHistory(repository),
        isParkingBrakeOn = IsParkingBrakeOn(repository),
    )
}