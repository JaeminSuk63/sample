package com.hyundai.sample.core

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.hyundai.sample.core.data.api.Api
import com.hyundai.sample.core.data.db.Database
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object TestHelper {

    fun getApi(): Api {
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

    fun getDatabase(): Database {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        return Room.databaseBuilder(context, Database::class.java, "test_db")
            .fallbackToDestructiveMigration()
            .build()
    }

}