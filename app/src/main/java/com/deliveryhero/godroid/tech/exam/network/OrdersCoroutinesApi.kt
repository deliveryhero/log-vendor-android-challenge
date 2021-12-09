package com.deliveryhero.godroid.tech.exam.network

import com.deliveryhero.godroid.tech.exam.network.data.Order
import retrofit2.http.GET
import retrofit2.http.Path

interface OrdersCoroutinesApi {

    @GET("orders")
    suspend fun getOrders(): List<Order>

    @GET("order/{id}")
    suspend fun getOrder(@Path("id") orderId: String): Order
}
