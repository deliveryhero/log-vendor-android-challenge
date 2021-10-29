package com.deliveryhero.godroid.tech.exam

import android.app.Application
import com.deliveryhero.godroid.tech.exam.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import timber.log.Timber
import timber.log.Timber.DebugTree
import java.io.IOException
import javax.inject.Inject

class ExamApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    override fun onCreate() {
        super.onCreate()

        injectDagger()
        setRxErrorHandler()
        setupTimber()
    }

    private fun injectDagger() {
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
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
