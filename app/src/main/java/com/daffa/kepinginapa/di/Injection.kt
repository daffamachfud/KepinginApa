package com.daffa.kepinginapa.di

import android.content.Context
import com.daffa.kepinginapa.data.local.LocalDataSource
import com.daffa.kepinginapa.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): AppRepository {

        val database = AppDatabase.getInstance(context)

        val localDataSource = LocalDataSource.getInstance(database.appDao())
        val appExecutors = AppExecutors()

        return AppRepository.getInstance(localDataSource, appExecutors)
    }
}