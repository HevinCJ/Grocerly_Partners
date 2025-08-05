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
    private val userId: String = auth.currentUser?.uid ?: ""
    private val orderRef = db.collection(PARTNERS).document(userId).collection(ORDERS)

    companion object {
        private const val TAG = "OrdersRepoImpl"
    }

    /**
     * Generic function to fetch orders by status
     */
    private fun fetchOrdersByStatus(status: OrderStatus): Flow<NetworkResult<List<Order>>> = callbackFlow {
        val listener = orderRef.addSnapshotListener { snapshot, exception ->
            trySend(NetworkResult.Loading())

            when {
                exception != null -> {
                    Log.e(TAG, "Error fetching $status orders", exception)
                    trySend(NetworkResult.Error(exception.message ?: "Unknown error occurred"))
                }
                snapshot == null || snapshot.isEmpty -> {
                    trySend(NetworkResult.Success(emptyList()))
                }
                else -> {
                    val orders = snapshot.documents
                        .mapNotNull { it.toObject(Order::class.java) }
                        .filter { order -> 
                            order.items.any { item -> 
                                item.orderStatus == status && item.product.partnerId == userId 
                            } 
                        }
                    
                    Log.d(TAG, "Fetched ${orders.size} $status orders")
                    trySend(NetworkResult.Success(orders))
                }
            }
        }

        awaitClose { listener.remove() }
    }

    fun fetchPendingOrders(): Flow<NetworkResult<List<Order>>> = fetchOrdersByStatus(OrderStatus.PENDING)
    fun fetchAcceptedOrders(): Flow<NetworkResult<List<Order>>> = fetchOrdersByStatus(OrderStatus.ACCEPTED)
    fun fetchReadyOrders(): Flow<NetworkResult<List<Order>>> = fetchOrdersByStatus(OrderStatus.READY)
    fun fetchShippedOrders(): Flow<NetworkResult<List<Order>>> = fetchOrdersByStatus(OrderStatus.SHIPPED)

    suspend fun setOrderStateInOrder(order: Order, status: OrderStatus): NetworkResult<Unit> {
        return try {
            if (userId.isEmpty()) {
                return NetworkResult.Error("User not authenticated")
            }

            val batch = db.batch()
            
            // Get the global order document
            val globalSnap = db.collection(ORDERS).document(order.orderId).get().await()
            val fullOrder = globalSnap.toObject(Order::class.java) 
                ?: return NetworkResult.Error("Order not found")

            // Update items for current partner
            val updatedItems = fullOrder.items.map { item ->
                if (item.product.partnerId == userId) {
                    item.copy(orderStatus = status)
                } else {
                    item
                }
            }

            val updatedGlobalOrder = fullOrder.copy(items = updatedItems)
            val sellerOrder = fullOrder.copy(
                items = updatedItems.filter { it.product.partnerId == userId }
            )

            // Prepare batch operations
            val globalRef = db.collection(ORDERS).document(order.orderId)
            val userRef = db.collection(USERS).document(order.userId).collection(ORDERS).document(order.orderId)
            val partnerRef = orderRef.document(order.orderId)

            // Add operations to batch
            batch.set(globalRef, updatedGlobalOrder.toMap(), SetOptions.merge())
            batch.set(userRef, updatedGlobalOrder.toMap(), SetOptions.merge())
            batch.set(partnerRef, sellerOrder.toMap(), SetOptions.merge())

            // Commit batch
            batch.commit().await()
            
            Log.d(TAG, "Successfully updated order ${order.orderId} to status $status")
            NetworkResult.Success(Unit)
        } catch (e: Exception) {
            Log.e(TAG, "Error updating order status", e)
            NetworkResult.Error(e.message ?: "Failed to update order status")
        }
    }

    // Extension functions for mapping objects to Firestore documents
    private fun Order.toMap(): Map<String, Any> = mapOf(
        "orderId" to orderId,
        "userId" to userId,
        "address" to address,
        "items" to items.map { it.toMap() },
        "timestamp" to timestamp,
        "totalOrderPrice" to totalOrderPrice,
        "paymentType" to paymentType
    )

    private fun CartProduct.toMap(): Map<String, Any?> = mapOf(
        "product" to product.toMap(),
        "quantity" to quantity,
        "deliveryDate" to deliveryDate,
        "deliveredDate" to deliveredDate,
        "orderStatus" to orderStatus,
        "cancellationInfo" to cancellationInfo?.toMap()
    )

    private fun Product.toMap(): Map<String, Any?> = mapOf(
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

    private fun CancellationInfo.toMap(): Map<String, Any?> = mapOf(
        "cancelledBy" to cancelledBy.name,
        "cancelledAt" to cancelledAt,
        "reason" to reason
    )
}