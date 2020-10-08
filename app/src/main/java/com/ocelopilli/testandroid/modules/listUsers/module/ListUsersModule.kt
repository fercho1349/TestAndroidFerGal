package com.ocelopilli.testandroid.modules.listUsers.module

import androidx.lifecycle.ViewModel
import com.ocelopilli.testandroid.annotations.ViewModelKey
import com.ocelopilli.testandroid.modules.listUsers.viewModel.ListUsersViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListUsersModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListUsersViewModel::class)
    abstract fun provideListUsersViewModel(listUsersViewModel: ListUsersViewModel): ViewModel

}