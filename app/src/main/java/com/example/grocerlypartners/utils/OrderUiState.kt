package com.example.grocerlypartners.utils

import com.example.grocerlypartners.model.CartProduct
import com.example.grocerlypartners.model.Order

sealed class OrderUiState {
    class Pending(val result: NetworkResult<List<Order>>) : OrderUiState()
    class Accepted(val result: NetworkResult<List<Order>>) : OrderUiState()
    class Ready(val result: NetworkResult<List<Order>>) : OrderUiState()
    class Shipped(val result: NetworkResult<List<Order>>) : OrderUiState()
    class OrderStatus(val result: NetworkResult<Unit> ): OrderUiState()
    class Cancelled(val result: NetworkResult<Map<String, List<CartProduct>>>) : OrderUiState()
}
