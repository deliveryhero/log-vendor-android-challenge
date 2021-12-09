package com.deliveryhero.godroid.tech.exam.repository

import com.deliveryhero.godroid.tech.exam.core.schedular.SchedulerProvider
import com.deliveryhero.godroid.tech.exam.network.Api
import com.deliveryhero.godroid.tech.exam.network.data.Order
import dagger.Reusable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

@Reusable
class OrdersRepository @Inject constructor(
    private val api: Api,
    private val schedulerProvider: SchedulerProvider
) {

    fun getOrders(): Single<List<Order>> =
        api.getOrders().subscribeOn(schedulerProvider.io())

    fun getOrder(id: String): Single<Order> =
        api.getOrder(id).subscribeOn(schedulerProvider.io())
}
