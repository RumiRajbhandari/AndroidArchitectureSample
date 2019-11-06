package com.rumi.architecturesample.di

import android.content.Context
import com.rumi.architecturesample.data.DatabaseManager
import com.rumi.architecturesample.local.PhotoLocalImpl
import com.rumi.architecturesample.remote.ApiModule
import com.rumi.architecturesample.remote.PhotoRemoteImpl
import com.rumi.architecturesample.repository.PhotoRepositoryImpl

class AppContainer(context: Context) {
    private val apiService = ApiModule.getRetrofitInstance()
    val databaseManager = DatabaseManager(context)
    private val photoRemote = PhotoRemoteImpl(apiService)
    private val photoLocal = PhotoLocalImpl(databaseManager)
    val photoRepositoryImpl = PhotoRepositoryImpl(photoLocal, photoRemote)

}