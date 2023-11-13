package com.hyundai.sample.core

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hyundai.sample.core.data.RepositoryImpl
import com.hyundai.sample.core.data.api.Api
import com.hyundai.sample.core.data.dataSources.LocalSource
import com.hyundai.sample.core.data.dataSources.LocalSourceImpl
import com.hyundai.sample.core.data.dataSources.RemoteSource
import com.hyundai.sample.core.data.dataSources.RemoteSourceImpl
import com.hyundai.sample.core.data.dataSources.VehicleSource
import com.hyundai.sample.core.data.dataSources.VehicleSourceImpl
import com.hyundai.sample.core.data.db.Database
import com.hyundai.sample.core.domain.Repository
import com.hyundai.sample.core.domain.SearchHistoryItem
import com.hyundai.sample.core.domain.UseCases
import com.hyundai.sample.core.domain.useCases.AddSearchHistory
import com.hyundai.sample.core.domain.useCases.DeleteSearchHistory
import com.hyundai.sample.core.domain.useCases.GetApiVersion
import com.hyundai.sample.core.domain.useCases.GetIgnitionState
import com.hyundai.sample.core.domain.useCases.GetSearchHistory
import com.hyundai.sample.core.domain.useCases.IsParkingBrakeOn
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UseCasesTest {
    val context = InstrumentationRegistry.getInstrumentation().targetContext
    private val localSource: LocalSource = LocalSourceImpl(getDatabase())
    private val remoteSource: RemoteSource = RemoteSourceImpl(getApi())
    private val vehicleSource: VehicleSource = VehicleSourceImpl(context)
    private val repository: Repository = RepositoryImpl(
        localSource,
        remoteSource,
        vehicleSource,
    )
    private val useCases = UseCases(
        addSearchHistory = AddSearchHistory(repository),
        deleteSearchHistory = DeleteSearchHistory(repository),
        getApiVersion = GetApiVersion(repository),
        getIgnitionState = GetIgnitionState(repository),
        getSearchHistory = GetSearchHistory(repository),
        isParkingBrakeOn = IsParkingBrakeOn(repository),
    )

    @Before
    fun setup() {

    }

    @Test
    fun addSearchHistoryTest() = runBlocking {
        val item = SearchHistoryItem(
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

    private fun getApi(): Api {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(7, TimeUnit.SECONDS)
            .connectTimeout(7, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://14rgey5i33.execute-api.ap-northeast-2.amazonaws.com")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(Api::class.java)
    }

    private fun getDatabase(): Database {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        return Room.databaseBuilder(context, Database::class.java, "local_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}