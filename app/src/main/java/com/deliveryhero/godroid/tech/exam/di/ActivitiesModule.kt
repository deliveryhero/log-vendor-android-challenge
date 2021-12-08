package com.deliveryhero.godroid.tech.exam.di;

import com.deliveryhero.godroid.tech.exam.ui.main.MainActivity;
import com.deliveryhero.godroid.tech.exam.ui.main.di.MainActivityModule
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
interface ActivitiesModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun mainActivityInjector(): MainActivity
}
