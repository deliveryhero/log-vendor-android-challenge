package com.deliveryhero.challenges.vendor.android.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.deliveryhero.challenges.vendor.android.MainCoroutineRule
import com.deliveryhero.challenges.vendor.android.data.AppDatabase
import com.deliveryhero.challenges.vendor.android.data.GardenPlantingRepository
import com.deliveryhero.challenges.vendor.android.data.PlantRepository
import com.deliveryhero.challenges.vendor.android.runBlockingTest
import com.deliveryhero.challenges.vendor.android.utilities.getValue
import com.deliveryhero.challenges.vendor.android.utilities.testPlant
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain
import javax.inject.Inject

@HiltAndroidTest
class PlantDetailViewModelTest {

    private lateinit var appDatabase: AppDatabase
    private lateinit var viewModel: PlantDetailViewModel
    private val hiltRule = HiltAndroidRule(this)
    private val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val coroutineRule = MainCoroutineRule()

    @get:Rule
    val rule = RuleChain
        .outerRule(hiltRule)
        .around(instantTaskExecutorRule)
        .around(coroutineRule)

    @Inject
    lateinit var plantRepository: PlantRepository

    @Inject
    lateinit var gardenPlantRepository: GardenPlantingRepository

    @Before
    fun setUp() {
        hiltRule.inject()

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()

        val savedStateHandle: SavedStateHandle = SavedStateHandle().apply {
            set("plantId", testPlant.plantId)
        }
        viewModel = PlantDetailViewModel(savedStateHandle, plantRepository, gardenPlantRepository)
    }

    @After
    fun tearDown() {
        appDatabase.close()
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    @Test
    @Throws(InterruptedException::class)
    fun testDefaultValues() = coroutineRule.runBlockingTest {
        assertFalse(getValue(viewModel.isPlanted))
    }
}
