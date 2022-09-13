package com.deliveryhero.godroid.tech.exam.core.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher

class TestDispatcherProvider(private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()) :
    DispatcherProvider {

    override fun default(): CoroutineDispatcher = testDispatcher

    override fun main(): CoroutineDispatcher = testDispatcher

    override fun io(): CoroutineDispatcher = testDispatcher

    override fun unconfined(): CoroutineDispatcher = testDispatcher
}
