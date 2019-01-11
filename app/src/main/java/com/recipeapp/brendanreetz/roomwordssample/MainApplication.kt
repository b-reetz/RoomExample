package com.recipeapp.brendanreetz.roomwordssample

import android.app.Application
import org.koin.android.ext.android.startKoin

@Suppress("unused")
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}