package com.deliveryhero.challenges.vendor.android.utilities

import org.junit.Assert.assertEquals
import org.junit.Test

class GrowZoneUtilTest {

    @Test
    fun getZoneForLatitude() {
        assertEquals(13, getZoneForLatitude(0.0))
        assertEquals(13, getZoneForLatitude(7.0))
        assertEquals(12, getZoneForLatitude(7.1))
        assertEquals(1, getZoneForLatitude(84.1))
        assertEquals(1, getZoneForLatitude(90.0))
    }

    @Test
    fun getZoneForLatitude_negativeLatitudes() {
        assertEquals(13, getZoneForLatitude(-7.0))
        assertEquals(12, getZoneForLatitude(-7.1))
        assertEquals(1, getZoneForLatitude(-84.1))
        assertEquals(1, getZoneForLatitude(-90.0))
    }

    // Bugfix test for https://github.com/android/sunflower/issues/8
    @Test
    fun getZoneForLatitude_GitHub_issue8() {
        assertEquals(9, getZoneForLatitude(35.0))
        assertEquals(8, getZoneForLatitude(42.0))
        assertEquals(7, getZoneForLatitude(49.0))
        assertEquals(6, getZoneForLatitude(56.0))
        assertEquals(5, getZoneForLatitude(63.0))
        assertEquals(4, getZoneForLatitude(70.0))
    }
}
