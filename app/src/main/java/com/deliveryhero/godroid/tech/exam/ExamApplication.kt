package com.deliveryhero.godroid.tech.exam

import com.deliveryhero.godroid.tech.exam.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import timber.log.Timber
import timber.log.Timber.DebugTree
import java.io.IOException

class ExamApplication : DaggerApplication(), HasAndroidInjector {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory()
            .create(this)

    override fun onCreate() {
        super.onCreate()

        setRxErrorHandler()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }

    private fun setRxErrorHandler() = RxJavaPlugins.setErrorHandler {
        when (it) {
            is UndeliverableException -> Timber.w(it)
            is IOException -> Unit
            is InterruptedException -> Unit
            is IllegalArgumentException,
            is NullPointerException,
            is IllegalStateException,
            -> sendErrorToUncaughtExceptionHandler(it)
        }
    }

    private fun sendErrorToUncaughtExceptionHandler(throwable: Throwable) {
        Thread.currentThread()
            .uncaughtExceptionHandler
            ?.uncaughtException(Thread.currentThread(), throwable)
    }
}
