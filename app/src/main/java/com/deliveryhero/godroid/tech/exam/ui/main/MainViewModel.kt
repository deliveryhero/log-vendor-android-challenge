package com.deliveryhero.godroid.tech.exam.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deliveryhero.godroid.tech.exam.core.schedular.SchedulerProvider
import com.deliveryhero.godroid.tech.exam.network.data.Order
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    repository: OrdersRepository,
    schedulerProvider: SchedulerProvider
) : ViewModel() {

    private val disposable by lazy { CompositeDisposable() }
    val orders = MutableLiveData<List<Order>>()

    init {
        repository.getOrders()
            .observeOn(schedulerProvider.main())
            .doOnSuccess {
                orders.value = it
            }
            .subscribe()
            .addTo(disposable)
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }
}
