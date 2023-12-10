package com.hyundai.sample.data.di

import android.content.Context
import androidx.room.Room
import com.hyundai.sample.data.db.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, "local_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}