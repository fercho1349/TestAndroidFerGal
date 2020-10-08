package com.ocelopilli.testandroid

import com.ocelopilli.testandroid.dagger.DaggerApplicationComponent
import com.ocelopilli.testandroid.managers.SharedPreferencesManager
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class TestAndroidApplication : DaggerApplication() {

    companion object {
        lateinit var prefs: SharedPreferencesManager
    }

    override fun onCreate() {
        super.onCreate()
        prefs = SharedPreferencesManager(applicationContext)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()
        appComponent.inject(this)
        return appComponent
    }
}