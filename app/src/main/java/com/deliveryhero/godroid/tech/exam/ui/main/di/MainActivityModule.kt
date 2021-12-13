package com.deliveryhero.godroid.tech.exam.ui.main.di

import com.deliveryhero.godroid.tech.exam.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    fun mainFragmentInjector(): MainFragment
}
