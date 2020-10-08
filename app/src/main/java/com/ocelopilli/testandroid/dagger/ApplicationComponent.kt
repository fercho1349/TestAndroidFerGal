package com.ocelopilli.testandroid.dagger

import com.ocelopilli.testandroid.TestAndroidApplication
import com.ocelopilli.testandroid.dagger.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        ActivityBuilderModule::class,
        ViewModelFactoryModule::class,
        RxModule::class,
        AndroidModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<TestAndroidApplication> {

    override fun inject(app: TestAndroidApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: TestAndroidApplication): Builder
        fun build(): ApplicationComponent
    }
}