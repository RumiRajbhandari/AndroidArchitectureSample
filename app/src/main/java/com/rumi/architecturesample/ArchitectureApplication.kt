package com.rumi.architecturesample

import android.app.Application
import com.facebook.stetho.Stetho
import com.rumi.architecturesample.di.AppContainer

class ArchitectureApplication: Application() {

    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer  = AppContainer(applicationContext)
        Stetho.initializeWithDefaults(applicationContext)
    }
}