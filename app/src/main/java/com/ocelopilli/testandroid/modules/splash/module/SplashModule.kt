package com.ocelopilli.testandroid.modules.splash.module

import androidx.lifecycle.ViewModel
import com.ocelopilli.testandroid.annotations.ViewModelKey
import com.ocelopilli.testandroid.modules.splash.viewModel.SplashViewModel
import com.ocelopilli.testandroid.modules.userDetail.view.viewModel.UserDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SplashModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashViewModel(splashViewModel: SplashViewModel): ViewModel

}