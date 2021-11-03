package com.deliveryhero.godroid.tech.exam.network.data

data class Order(
    val id: String,
    val state: OrderState,
    val items: List<String>,
    val total: Double
)

enum class OrderState {
    NEW,
    UPCOMING,
    ACCEPTED,
    CLOSED,
    CANCELLED
}
