package com.deliveryhero.godroid.tech.exam.core.scheduler

import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.schedulers.TestScheduler

class ImmediateSchedulerProvider : SchedulerProvider {

    private val testScheduler = TestScheduler()

    override fun computation(): Scheduler = Schedulers.trampoline()

    override fun io(): Scheduler = Schedulers.trampoline()

    override fun main(): Scheduler = Schedulers.trampoline()

    override fun single(): Scheduler = Schedulers.trampoline()

    override fun time(): Scheduler = testScheduler
}
