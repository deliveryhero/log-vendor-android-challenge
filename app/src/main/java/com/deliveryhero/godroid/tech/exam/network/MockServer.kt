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
        RequestFilter(path = "/order/1") to MockResponse().apply {
            setResponseCode(200)
            setBody(readFile(R.raw.order_1))
        },
        RequestFilter(path = "/order/2") to MockResponse().apply {
            setResponseCode(200)
            setBody(readFile(R.raw.order_2))
        },
        RequestFilter(path = "/order/3") to MockResponse().apply {
            setResponseCode(200)
            setBody(readFile(R.raw.order_3))
        },
        RequestFilter(path = "/order/4") to MockResponse().apply {
            setResponseCode(200)
            setBody(readFile(R.raw.order_4))
        },
        RequestFilter(path = "/order/5") to MockResponse().apply {
            setResponseCode(200)
            setBody(readFile(R.raw.order_5))
        },
    )

    private fun readFile(fileResId: Int): String =
        context.resources.openRawResource(fileResId).readBytes().toString(Charsets.UTF_8)
}
