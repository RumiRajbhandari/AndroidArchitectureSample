package com.rumi.architecturesample

import android.app.Application
import com.facebook.stetho.Stetho

class ArchitecureApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(applicationContext)
    }
}