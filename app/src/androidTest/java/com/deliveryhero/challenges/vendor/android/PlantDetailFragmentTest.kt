package com.deliveryhero.challenges.vendor.android

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.deliveryhero.challenges.vendor.android.utilities.chooser
import com.deliveryhero.challenges.vendor.android.utilities.testPlant
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PlantDetailFragmentTest {

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule(GardenActivity::class.java)

    @Before
    fun jumpToPlantDetailFragment() {
        activityTestRule.activity.apply {
            runOnUiThread {
                val bundle = Bundle().apply { putString("plantId", testPlant.plantId) }
                findNavController(R.id.nav_host).navigate(R.id.plant_detail_fragment, bundle)
            }
        }
    }

    @Ignore("Share button redesign pending")
    @Test
    fun testShareTextIntent() {
        val shareText = activityTestRule.activity.getString(
            R.string.share_text_plant,
            testPlant.name
        )

        Intents.init()
        onView(withId(R.id.action_share)).perform(click())
        intended(
            chooser(
                allOf(
                    hasAction(Intent.ACTION_SEND),
                    hasType("text/plain"),
                    hasExtra(Intent.EXTRA_TEXT, shareText)
                )
            )
        )
        Intents.release()

        // dismiss the Share Dialog
        InstrumentationRegistry.getInstrumentation()
            .uiAutomation
            .performGlobalAction(AccessibilityService.GLOBAL_ACTION_BACK)
    }
}
