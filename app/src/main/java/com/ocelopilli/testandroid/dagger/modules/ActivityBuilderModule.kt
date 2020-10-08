package com.ocelopilli.testandroid.dagger.modules

import com.android.`var`.annotations.PerActivity
import com.ocelopilli.testandroid.modules.listUsers.module.ListUsersModule
import com.ocelopilli.testandroid.modules.login.module.LoginModule
import com.ocelopilli.testandroid.modules.register.module.RegisterModule
import com.ocelopilli.testandroid.modules.userDetail.view.module.UserDetailModule
import com.ocelopilli.testandroid.modules.listUsers.view.ListUsersActivity
import com.ocelopilli.testandroid.modules.login.view.LoginActivity
import com.ocelopilli.testandroid.modules.register.view.RegisterActivity
import com.ocelopilli.testandroid.modules.splash.module.SplashModule
import com.ocelopilli.testandroid.modules.splash.view.SplashActivity
import com.ocelopilli.testandroid.modules.userDetail.view.view.UserDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            SplashModule::class
        ]
    )
    internal abstract fun bindSplashActivity(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            LoginModule::class
        ]
    )
    internal abstract fun bindLoginActivity(): LoginActivity

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            RegisterModule::class
        ]
    )
    internal abstract fun bindRegisterActivity(): RegisterActivity

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            ListUsersModule::class
        ]
    )
    internal abstract fun bindListUsersActivity(): ListUsersActivity

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            UserDetailModule::class
        ]
    )
    internal abstract fun bindUserDetailActivity(): UserDetailActivity

}