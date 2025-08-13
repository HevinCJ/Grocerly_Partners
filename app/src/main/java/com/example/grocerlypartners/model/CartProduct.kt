package com.example.grocerlypartners.model

import android.os.Parcelable
import com.example.grocerlypartners.utils.OrderStatus
import kotlinx.parcelize.Parcelize

@Parcelize
data class CartProduct(
    val product: Product = Product(),
    var quantity:Int = 1,
    val deliveryDate: String = "",
    val deliveredDate: String = "",
    val orderStatus: OrderStatus = OrderStatus.PENDING,
    val cancellationInfo: CancellationInfo = CancellationInfo()
): Parcelable