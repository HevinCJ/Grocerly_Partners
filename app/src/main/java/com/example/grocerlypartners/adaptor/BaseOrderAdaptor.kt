package com.example.grocerlypartners.adaptor

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerlypartners.model.Order

abstract class BaseOrderAdaptor: ListAdapter<Order, BaseOrderAdaptor.BaseOrderViewHolder>(DiffCallback) {

    companion object {
        val DiffCallback = object : DiffUtil.ItemCallback<Order>() {
            override fun areItemsTheSame(oldItem: Order, newItem: Order): Boolean =
                oldItem.orderId == newItem.orderId

            override fun areContentsTheSame(oldItem: Order, newItem: Order): Boolean =
                oldItem == newItem
        }

    }


    abstract class BaseOrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(order: Order)
    }

    override fun onBindViewHolder(holder: BaseOrderViewHolder, position: Int) {
        holder.bind(getItem(position))

    }


}