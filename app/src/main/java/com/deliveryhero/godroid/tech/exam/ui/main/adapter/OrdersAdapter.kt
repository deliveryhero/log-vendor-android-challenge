package com.deliveryhero.godroid.tech.exam.ui.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.deliveryhero.godroid.tech.exam.databinding.OrderItemBinding
import com.deliveryhero.godroid.tech.exam.network.data.Order
import com.deliveryhero.godroid.tech.exam.ui.main.adapter.OrdersAdapter.OrderItemViewHolder

class OrdersAdapter : Adapter<OrderItemViewHolder>() {
    private var items: List<Order> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderItemViewHolder {
        val binding = OrderItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OrderItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderItemViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Order>) {
        this.items = items
        notifyDataSetChanged()
    }

    inner class OrderItemViewHolder(private val binding: OrderItemBinding) : ViewHolder(binding.root) {

        fun bind(order: Order) {
            binding.orderId.text = order.id
            binding.orderStatus.text = order.state.name
        }
    }
}
