package com.deliveryhero.godroid.tech.exam.network

import com.deliveryhero.godroid.tech.exam.network.data.Order
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {

    @GET("orders")
    fun getOrders(): Single<List<String>>

    @GET("order/{id}")
    fun getOrders(@Path("id") orderId: String): Single<Order>
}
