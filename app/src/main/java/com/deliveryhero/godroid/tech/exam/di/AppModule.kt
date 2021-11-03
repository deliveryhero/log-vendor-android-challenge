package com.deliveryhero.godroid.tech.exam.di

import android.app.Application
import com.deliveryhero.godroid.tech.exam.ExamApplication
import dagger.Binds
import dagger.Module

@Module
interface AppModule {

    @Binds
    fun application(app: ExamApplication): Application
}
