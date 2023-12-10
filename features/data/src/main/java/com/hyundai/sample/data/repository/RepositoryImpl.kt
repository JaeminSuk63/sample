package com.hyundai.sample.data.repository

import com.hyundai.sample.data.dataSource.LocalSource
import com.hyundai.sample.data.dataSource.RemoteSource
import com.hyundai.sample.data.dataSource.VehicleSource
import com.hyundai.sample.entity.SearchHistoryItem

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