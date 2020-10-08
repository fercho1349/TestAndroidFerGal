package com.ocelopilli.testandroid.dagger.modules

import androidx.lifecycle.ViewModelProvider
import com.ocelopilli.testandroid.base.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {

    @Binds
    @Singleton
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}