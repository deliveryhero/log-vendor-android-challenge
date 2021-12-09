package com.deliveryhero.godroid.tech.exam.network

import android.content.Context
import com.appham.mockinizer.RequestFilter
import com.deliveryhero.godroid.tech.exam.R
import okhttp3.mockwebserver.MockResponse
import javax.inject.Inject

class MockServer @Inject constructor(
    private val context: Context
) {
    fun getMocks() = mapOf(
        RequestFilter("/orders") to MockResponse().apply {
            setResponseCode(200)
            setBody(readFile(R.raw.orders))
        },
    )

    private fun readFile(fileResId: Int): String =
        context.resources.openRawResource(fileResId).readBytes().toString(Charsets.UTF_8)
}
