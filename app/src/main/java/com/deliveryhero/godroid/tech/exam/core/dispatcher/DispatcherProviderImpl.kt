package com.deliveryhero.godroid.tech.exam.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DispatcherProviderImpl : DispatcherProvider {

    override fun default(): CoroutineDispatcher = Dispatchers.Default

    override fun main(): CoroutineDispatcher = Dispatchers.Main

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined
}
