package com.deliveryhero.godroid.tech.exam.di

import com.deliveryhero.godroid.tech.exam.ExamApplication
import com.deliveryhero.godroid.tech.exam.network.di.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        ActivitiesModule::class,
        AndroidSupportInjectionModule::class,
    ]
)
interface AppComponent : AndroidInjector<ExamApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<ExamApplication>
}
