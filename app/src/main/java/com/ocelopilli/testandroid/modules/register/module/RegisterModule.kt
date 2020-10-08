package com.ocelopilli.testandroid.modules.register.module

import androidx.lifecycle.ViewModel
import com.ocelopilli.testandroid.annotations.ViewModelKey
import com.ocelopilli.testandroid.modules.register.viewModel.RegisterViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class RegisterModule {

    @Binds
    @IntoMap
    @ViewModelKey(RegisterViewModel::class)
    abstract fun provideRegisterViewModel(registerViewModel: RegisterViewModel): ViewModel

}