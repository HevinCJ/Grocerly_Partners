package com.example.grocerlypartners.repository

import android.util.Log
import com.example.grocerlypartners.model.Address
import com.example.grocerlypartners.model.CancellationInfo
import com.example.grocerlypartners.model.CartProduct
import com.example.grocerlypartners.model.Order
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.Constants.ORDERS
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.USERS
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OrderStatus
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@ActivityRetainedScoped
class OrdersRepoImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore
) {

    private val userId = auth.currentUser?.uid.toString()
    private val orderRef = db.collection(PARTNERS).document(userId).collection(ORDERS)

    // Generic method to fetch orders by status
    private fun fetchOrdersByStatus(status: OrderStatus): Flow<NetworkResult<List<Order>>> = callbackFlow {
        val listener = orderRef.addSnapshotListener { snapshot, exception ->
            trySend(NetworkResult.Loading())

            if (exception != null) {
                trySend(NetworkResult.Error(exception.message ?: "Unknown error occurred"))
                return@addSnapshotListener
            }

            if (snapshot == null || snapshot.isEmpty) {
                trySend(NetworkResult.Success(emptyList()))
                return@addSnapshotListener
            }

            try {
                val orders = snapshot.documents
                    .mapNotNull { it.toObject(Order::class.java) }
                    .filter { order -> 
                        order.items.any { 
                            it.orderStatus == status && it.product.partnerId == userId 
                        } 
                    }

                trySend(NetworkResult.Success(orders))
                Log.d("OrdersRepo", "Fetched ${orders.size} $status orders")
            } catch (e: Exception) {
                trySend(NetworkResult.Error("Error parsing orders: ${e.message}"))
            }
        }

        awaitClose {
            listener.remove()
        }
    }

    fun fetchPendingOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.PENDING)

    fun fetchAcceptedOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.ACCEPTED)

    fun fetchReadyOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.READY)

    fun fetchShippedOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.SHIPPED)

    suspend fun setOrderStateInOrder(order: Order, status: OrderStatus): NetworkResult<Unit> {
        return try {
            val batch = db.batch()
            
            // Get the global order document
            val globalSnap = db.collection(ORDERS).document(order.orderId).get().await()
            val fullOrder = globalSnap.toObject(Order::class.java)
            
            if (fullOrder == null) {
                return NetworkResult.Error("Order not found")
            }

            // Update items for this partner
            val updatedItems = fullOrder.items.map { cartProduct ->
                if (cartProduct.product.partnerId == userId) {
                    cartProduct.copy(orderStatus = status)
                } else {
                    cartProduct
                }
            }

            val updatedGlobalOrder = fullOrder.copy(items = updatedItems)
            
            // References for batch operations
            val userRef = db.collection(USERS).document(order.userId).collection(ORDERS).document(order.orderId)
            val partnerRef = orderRef.document(order.orderId)
            val globalRef = db.collection(ORDERS).document(order.orderId)

            // Update global order (all items)
            batch.set(globalRef, updatedGlobalOrder.toMap(), SetOptions.merge())
            
            // Update user's order view
            batch.set(userRef, updatedGlobalOrder.toMap(), SetOptions.merge())
            
            // Update partner's order view (only their items)
            val partnerOrder = fullOrder.copy(items = updatedItems.filter { it.product.partnerId == userId })
            batch.set(partnerRef, partnerOrder.toMap(), SetOptions.merge())

            batch.commit().await()
            NetworkResult.Success(Unit)
            
        } catch (e: Exception) {
            Log.e("OrdersRepo", "Error updating order status", e)
            NetworkResult.Error("Failed to update order status: ${e.message}")
        }
    }

    // Extension functions for mapping objects to Firestore documents
    private fun Order.toMap(): Map<String, Any> {
        return mapOf(
            "orderId" to orderId,
            "userId" to userId,
            "address" to address,
            "items" to items.map { it.toMap() },
            "timestamp" to timestamp,
            "totalOrderPrice" to totalOrderPrice,
            "paymentType" to paymentType
        )
    }

    private fun CartProduct.toMap(): Map<String, Any?> {
        return mapOf(
            "product" to product.toMap(),
            "quantity" to quantity,
            "deliveryDate" to deliveryDate,
            "deliveredDate" to deliveredDate,
            "orderStatus" to orderStatus,
            "cancellationInfo" to cancellationInfo?.toMap()
        )
    }

    private fun Product.toMap(): Map<String, Any?> {
        return mapOf(
            "productId" to productId,
            "partnerId" to partnerId,
            "image" to image,
            "itemName" to itemName,
            "itemPrice" to itemPrice,
            "category" to category.name,
            "itemRating" to itemRating,
            "totalRating" to totalRating,
            "isOrdered" to isOrdered
        )
    }

    private fun CancellationInfo.toMap(): Map<String, Any?> {
        return mapOf(
            "cancelledBy" to cancelledBy.name,
            "cancelledAt" to cancelledAt,
            "reason" to reason
        )
    }
}