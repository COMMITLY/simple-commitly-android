package com.dlrjsgml.hiltman

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HiltManApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}