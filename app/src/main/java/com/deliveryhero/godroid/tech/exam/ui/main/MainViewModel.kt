package com.deliveryhero.godroid.tech.exam.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deliveryhero.godroid.tech.exam.repository.OrdersRepository
import com.deliveryhero.godroid.tech.exam.core.schedular.SchedulerProvider
import com.deliveryhero.godroid.tech.exam.network.data.Order
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class MainViewModel @Inject constructor(
    repository: OrdersRepository,
    schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val disposable by lazy { CompositeDisposable() }
    private val _orders = MutableLiveData<List<Order>>()
    val orders: LiveData<List<Order>> = _orders

    init {
        repository.getOrders()
            .observeOn(schedulerProvider.main())
            .subscribeBy {
                _orders.value = it
            }
            .addTo(disposable)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}
