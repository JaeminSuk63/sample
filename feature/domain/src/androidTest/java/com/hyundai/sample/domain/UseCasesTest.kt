package com.hyundai.sample.domain

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hyundai.sample.repository.Repository
import com.hyundai.sample.repository.data.dataSources.LocalSource
import com.hyundai.sample.repository.data.dataSources.LocalSourceImpl
import com.hyundai.sample.repository.data.dataSources.RemoteSource
import com.hyundai.sample.repository.data.dataSources.RemoteSourceImpl
import com.hyundai.sample.repository.data.dataSources.VehicleSource
import com.hyundai.sample.repository.data.dataSources.VehicleSourceImpl
import com.hyundai.sample.repository.data.repository.RepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UseCasesTest {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val localSource: LocalSource = LocalSourceImpl(TestHelper.getDatabase())
    private val remoteSource: RemoteSource = RemoteSourceImpl(TestHelper.getApi())
    private val vehicleSource: VehicleSource = VehicleSourceImpl(context)
    private val repository: Repository = RepositoryImpl(
        localSource,
        remoteSource,
        vehicleSource,
    )
    private val useCases = UseCases(
        addSearchHistory = com.hyundai.sample.domain.useCases.AddSearchHistory(repository),
        deleteSearchHistory = com.hyundai.sample.domain.useCases.DeleteSearchHistory(repository),
        getApiVersion = com.hyundai.sample.domain.useCases.GetApiVersion(repository),
        getIgnitionState = com.hyundai.sample.domain.useCases.GetIgnitionState(repository),
        getSearchHistory = com.hyundai.sample.domain.useCases.GetSearchHistory(repository),
        isParkingBrakeOn = com.hyundai.sample.domain.useCases.IsParkingBrakeOn(repository),
    )

    @Before
    fun setup() {
    }

    @Test
    fun addSearchHistoryTest() = runBlocking {
        val item = com.hyundai.sample.entity.SearchHistoryItem(
            keyword = "Add"
        )
        useCases.addSearchHistory(item)
    }

    @Test
    fun getSearchHistoryTest() = runBlocking {
        val expected = "Add"
        val data = useCases.getSearchHistory().first()
        val actual = data[0].keyword
        assertEquals(expected, actual)
    }

    @Test
    fun deleteSearchHistoryTest() = runBlocking {
        val data = useCases.getSearchHistory().first()
        val actual = data[0]
        useCases.deleteSearchHistory(actual)
    }

    @Test
    fun getApiVersionTest() = runBlocking {
        val expected = 5
        val actual = useCases.getApiVersion()
        assertEquals(expected, actual)
    }

    @Test
    fun getIgnitionTest() = runBlocking {
        val expected = 4
        val actual = useCases.getIgnitionState().first()
        assertEquals(expected, actual)
    }

    @Test
    fun isParkingBrakeOnTest() {
        val expected = false
        val actual = useCases.isParkingBrakeOn()
        assertEquals(expected, actual)
    }
}