package com.deliveryhero.godroid.tech.exam.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {

    fun default(): CoroutineDispatcher

    fun main(): CoroutineDispatcher

    fun io(): CoroutineDispatcher

    fun unconfined(): CoroutineDispatcher
}
