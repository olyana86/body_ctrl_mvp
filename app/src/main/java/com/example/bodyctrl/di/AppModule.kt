package com.example.bodyctrl.di

import android.content.Context
import com.example.bodyctrl.data.BodyCtrlDao
import com.example.bodyctrl.data.BodyCtrlDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideBodyCtrlDatabase(@ApplicationContext context: Context) : BodyCtrlDatabase {
        return BodyCtrlDatabase.getInstance(context)
    }

    @Provides
    fun provideBodyCtrlDao(bodyCtrlDatabase: BodyCtrlDatabase) : BodyCtrlDao {
        return bodyCtrlDatabase.bodyCtrlDao()
    }
}