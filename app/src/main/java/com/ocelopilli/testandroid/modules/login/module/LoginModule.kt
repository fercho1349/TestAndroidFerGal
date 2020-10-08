package com.ocelopilli.testandroid.modules.login.module

import androidx.lifecycle.ViewModel
import com.ocelopilli.testandroid.annotations.ViewModelKey
import com.ocelopilli.testandroid.modules.login.viewModel.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class LoginModule {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun provideLoginViewModel(loginViewModel: LoginViewModel): ViewModel

}