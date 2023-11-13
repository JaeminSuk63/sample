package com.hyundai.sample.core.data

import com.hyundai.sample.core.data.dataSources.LocalSource
import com.hyundai.sample.core.data.dataSources.RemoteSource
import com.hyundai.sample.core.data.dataSources.VehicleSource
import com.hyundai.sample.core.domain.Repository
import com.hyundai.sample.core.domain.SearchHistoryItem

class RepositoryImpl(
    private val localSource: LocalSource,
    private val remoteSource: RemoteSource,
    private val vehicleSource: VehicleSource,
) : Repository {
    override suspend fun addSearchHistory(item: SearchHistoryItem) =
        localSource.addSearchHistory(item)

    override suspend fun deleteSearchHistory(item: SearchHistoryItem) =
        localSource.deleteSearchHistory(item)

    override fun getSearchHistory() = localSource.getSearchHistory()

    override suspend fun getApiVersion() = remoteSource.getApiVersion()

    override fun getIgnitionState() = vehicleSource.getIgnitionState()

    override fun isParkingBrakeOn() = vehicleSource.isParkingBrakeOn()
}