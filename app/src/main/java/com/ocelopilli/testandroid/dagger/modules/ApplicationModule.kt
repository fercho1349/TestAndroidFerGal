package com.ocelopilli.testandroid.dagger.modules

import android.app.Application
import android.content.Context
import com.ocelopilli.testandroid.managers.SharedPreferencesManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun sharedPreferencesManager(application: Application): SharedPreferencesManager = SharedPreferencesManager(application)

}