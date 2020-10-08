package com.ocelopilli.testandroid.modules.userDetail.view.module

import androidx.lifecycle.ViewModel
import com.ocelopilli.testandroid.annotations.ViewModelKey
import com.ocelopilli.testandroid.modules.userDetail.view.viewModel.UserDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class UserDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun provideUserDetailViewModel(userDetailViewModel: UserDetailViewModel): ViewModel

}