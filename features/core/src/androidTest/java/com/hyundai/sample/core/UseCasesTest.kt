package com.hyundai.sample.core

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.hyundai.sample.core.data.RepositoryImpl
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
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class UseCasesTest {
    private val repository: Repository = RepositoryImpl()
    private val useCases = UseCases(
        addSearchHistory = AddSearchHistory(repository),
        deleteSearchHistory = DeleteSearchHistory(repository),
        getApiVersion = GetApiVersion(repository),
        getIgnitionState = GetIgnitionState(repository),
        getSearchHistory = GetSearchHistory(repository),
        isParkingBrakeOn = IsParkingBrakeOn(repository),
    )

    @Test
    fun addSearchHistoryTest() {
        val expected = 0
        val actual = 1
        val item = SearchHistoryItem()
        useCases.addSearchHistory(item)
        assertEquals(expected, actual)
    }

    @Test
    fun deleteSearchHistoryTest() {
        val expected = 0
        val actual = 1
        val item = SearchHistoryItem()
        useCases.deleteSearchHistory(item)
        assertEquals(expected, actual)
    }

    @Test
    fun getApiVersionTest() {
        val expected = 0
        val actual = useCases.getApiVersion()
        assertEquals(expected, actual)
    }

    @Test
    fun getIgnitionTest() = runBlocking {
        val expected = 0
        val actual = useCases.getIgnitionState().first()
        assertEquals(expected, actual)
    }

    @Test
    fun getSearchHistoryTest() {
        val expected = 0
        val actual = 1
        useCases.getSearchHistory()
        assertEquals(expected, actual)
    }

    @Test
    fun isParkingBrakeOnTest() {
        val expected = false
        val actual = useCases.isParkingBrakeOn()
        assertEquals(expected, actual)
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.hyundai.sample.core.test", appContext.packageName)
    }
}