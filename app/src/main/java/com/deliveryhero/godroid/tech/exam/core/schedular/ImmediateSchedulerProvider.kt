package com.deliveryhero.godroid.tech.exam.core.schedular

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class AndroidSchedulerProvider @Inject constructor() : SchedulerProvider {

    override fun computation() = Schedulers.computation()

    override fun io() = Schedulers.io()

    override fun main() = AndroidSchedulers.mainThread()

    override fun single() = Schedulers.single()

    override fun time() = Schedulers.computation()
}
