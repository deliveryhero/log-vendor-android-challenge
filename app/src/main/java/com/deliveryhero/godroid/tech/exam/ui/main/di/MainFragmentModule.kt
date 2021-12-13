package com.deliveryhero.godroid.tech.exam.ui.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.deliveryhero.godroid.tech.exam.core.ViewModelKey
import com.deliveryhero.godroid.tech.exam.core.ViewModelFactory
import com.deliveryhero.godroid.tech.exam.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainFragmentModule {

    @Binds
    fun bindViewModelFactory(it: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(it: MainViewModel): ViewModel
}
