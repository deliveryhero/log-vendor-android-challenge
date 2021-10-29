package com.deliveryhero.godroid.tech.exam.network.data

data class Order(
    val id: String,
    val state: STATE,
    val items: List<String>,
    val total: Double
)

enum class STATE {
    NEW,
    UPCOMING,
    ACCEPTED,
    CLOSED,
    CANCELLED
}
