package com.deliveryhero.godroid.tech.exam.repository

import com.deliveryhero.godroid.tech.exam.core.schedular.SchedulerProvider
import com.deliveryhero.godroid.tech.exam.network.OrdersCoroutinesApi
import com.deliveryhero.godroid.tech.exam.network.OrdersRxApi
import com.deliveryhero.godroid.tech.exam.network.data.Order
import dagger.Reusable
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@Reusable
class OrdersRepository @Inject constructor(
    private val ordersRxApi: OrdersRxApi,
    private val ordersCoroutinesApi: OrdersCoroutinesApi,
    private val schedulerProvider: SchedulerProvider
) {

    fun getRxOrders(): Single<List<Order>> =
        ordersRxApi.getOrders().subscribeOn(schedulerProvider.io())

    fun getRxOrder(id: String): Single<Order> =
        ordersRxApi.getOrder(id).subscribeOn(schedulerProvider.io())

    suspend fun getCoroutinesOrders(): List<Order> =
        withContext(Dispatchers.IO) {
            ordersCoroutinesApi.getOrders()
        }

    suspend fun getCoroutinesOrder(id: String): Order =
        withContext(Dispatchers.IO) {
            ordersCoroutinesApi.getOrder(id)
        }
}
