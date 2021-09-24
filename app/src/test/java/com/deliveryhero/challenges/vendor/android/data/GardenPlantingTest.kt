package com.deliveryhero.challenges.vendor.android.data

import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import java.util.Calendar

class GardenPlantingTest {

    @Test
    fun testDefaultValues() {
        val gardenPlanting = GardenPlanting("1")
        val cal = Calendar.getInstance()
        assertYMD(cal, gardenPlanting.plantDate)
        assertYMD(cal, gardenPlanting.lastWateringDate)
        assertEquals(0L, gardenPlanting.gardenPlantingId)
    }

    // Only Year/Month/Day precision is needed for comparing GardenPlanting Calendar entries
    private fun assertYMD(expectedCal: Calendar, actualCal: Calendar) {
        assertThat(
            actualCal.get(Calendar.YEAR),
            equalTo(expectedCal.get(Calendar.YEAR))
        )
        assertThat(
            actualCal.get(Calendar.MONTH),
            equalTo(expectedCal.get(Calendar.MONTH))
        )
        assertThat(
            actualCal.get(Calendar.DAY_OF_MONTH),
            equalTo(expectedCal.get(Calendar.DAY_OF_MONTH))
        )
    }
}
