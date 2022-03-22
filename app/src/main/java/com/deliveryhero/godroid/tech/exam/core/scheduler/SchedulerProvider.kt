package com.deliveryhero.godroid.tech.exam.core.scheduler

import io.reactivex.rxjava3.core.Scheduler

interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun main(): Scheduler

    fun single(): Scheduler

    fun time(): Scheduler
}
