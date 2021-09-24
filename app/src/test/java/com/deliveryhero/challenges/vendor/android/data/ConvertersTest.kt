package com.deliveryhero.challenges.vendor.android.data

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Calendar

class ConvertersTest {

    private val cal = Calendar.getInstance().apply {
        set(Calendar.YEAR, 1998)
        set(Calendar.MONTH, Calendar.SEPTEMBER)
        set(Calendar.DAY_OF_MONTH, 4)
    }

    @Test
    fun calendarToDatestamp() {
        assertEquals(cal.timeInMillis, Converters().calendarToDatestamp(cal))
    }

    @Test
    fun datestampToCalendar() {
        assertEquals(Converters().datestampToCalendar(cal.timeInMillis), cal)
    }
}
