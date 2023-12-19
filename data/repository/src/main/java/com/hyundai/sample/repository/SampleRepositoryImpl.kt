package com.hyundai.sample.repository

import com.hyundai.sample.entity.SearchHistoryItem
import com.hyundai.sample.repository.datasource.LocalSource
import com.hyundai.sample.repository.datasource.RemoteSource
import com.hyundai.sample.repository.datasource.VehicleSource
import com.hyundai.sample.usecase.SampleRepository

class SampleRepositoryImpl(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource,
    private val vehicleSource: VehicleSource,
) : SampleRepository {
    
    override suspend fun addSearchHistory(item: SearchHistoryItem) =
        localSource.addSearchHistory(item)

    override suspend fun deleteSearchHistory(item: SearchHistoryItem) =
        localSource.deleteSearchHistory(item)

    override fun getSearchHistory() = localSource.getSearchHistory()

    override suspend fun getApiVersion() = remoteSource.getApiVersion()

    override fun getIgnitionState() = vehicleSource.getIgnitionState()

    override fun isParkingBrakeOn() = vehicleSource.isParkingBrakeOn()
}