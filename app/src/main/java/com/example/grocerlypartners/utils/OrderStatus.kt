package com.example.grocerlypartners.utils

import com.google.android.play.core.integrity.t
import kotlin.collections.firstOrNull
import kotlin.text.equals

enum class OrderStatus(val status: String) {
    PENDING("Pending"),
    ACCEPTED("Accepted"),
    READY("Ready"),
    SHIPPED("Shipped"),
    OUTFORDELIVERY("OutForDelivery"),
    DELIVERED("Delivered");


    companion object{
        fun fromStatus(status: String): OrderStatus{
            return OrderStatus.entries.firstOrNull { it.status.equals(status, true) } ?: PENDING
        }
    }
}