package com.hyundai.sample.repository

import com.hyundai.sample.repository.dataSource.LocalSource
import com.hyundai.sample.repository.dataSource.RemoteSource
import com.hyundai.sample.repository.dataSource.VehicleSource

class RepositoryImpl(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource,
    private val vehicleSource: VehicleSource,
) : Repository {
    override suspend fun addSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem) =
        localSource.addSearchHistory(item)

    override suspend fun deleteSearchHistory(item: com.hyundai.sample.entity.SearchHistoryItem) =
        localSource.deleteSearchHistory(item)

    override fun getSearchHistory() = localSource.getSearchHistory()

    override suspend fun getApiVersion() = remoteSource.getApiVersion()

    override fun getIgnitionState() = vehicleSource.getIgnitionState()

    override fun isParkingBrakeOn() = vehicleSource.isParkingBrakeOn()
}