package com.deliveryhero.challenges.vendor.android.worker

import android.content.Context
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.work.Configuration
import androidx.work.ListenableWorker.Result
import androidx.work.WorkManager
import androidx.work.testing.SynchronousExecutor
import androidx.work.testing.TestListenableWorkerBuilder
import androidx.work.testing.WorkManagerTestInitHelper
import androidx.work.workDataOf
import com.deliveryhero.challenges.vendor.android.utilities.PLANT_DATA_FILENAME
import com.deliveryhero.challenges.vendor.android.workers.SeedDatabaseWorker
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RefreshMainDataWorkTest {
    private lateinit var workManager: WorkManager
    private lateinit var context: Context
    private lateinit var configuration: Configuration

    @Before
    fun setup() {
        // Configure WorkManager
        configuration = Configuration.Builder()
            // Set log level to Log.DEBUG to make it easier to debug
            .setMinimumLoggingLevel(Log.DEBUG)
            // Use a SynchronousExecutor here to make it easier to write tests
            .setExecutor(SynchronousExecutor())
            .build()

        // Initialize WorkManager for instrumentation tests.
        context = InstrumentationRegistry.getInstrumentation().targetContext
        WorkManagerTestInitHelper.initializeTestWorkManager(context, configuration)
        workManager = WorkManager.getInstance(context)
    }

    @Test
    fun testRefreshMainDataWork() {
        // Get the ListenableWorker
        val worker = TestListenableWorkerBuilder<SeedDatabaseWorker>(
            context = context,
            inputData = workDataOf(SeedDatabaseWorker.KEY_FILENAME to PLANT_DATA_FILENAME)
        ).build()

        // Start the work synchronously
        val result = worker.startWork().get()

        assertThat(result, `is`(Result.success()))
    }
}
