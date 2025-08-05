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

    private val userId = auth.currentUser?.uid ?: throw IllegalStateException("User not authenticated")
    private val orderRef = db.collection(PARTNERS).document(userId).collection(ORDERS)

    fun fetchPendingOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.PENDING, "Pendingorderrepo")

    fun fetchAcceptedOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.ACCEPTED)

    fun fetchReadyOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.READY)

    fun fetchShippedOrders(): Flow<NetworkResult<List<Order>>> = 
        fetchOrdersByStatus(OrderStatus.SHIPPED)

    private fun fetchOrdersByStatus(
        status: OrderStatus,
        logTag: String? = null
    ): Flow<NetworkResult<List<Order>>> = callbackFlow {
        trySend(NetworkResult.Loading())
        
        val listener = orderRef.addSnapshotListener { snapshot, exception ->
            when {
                exception != null -> {
                    trySend(NetworkResult.Error(exception.message ?: "Unknown error occurred"))
                }
                snapshot == null || snapshot.isEmpty -> {
                    trySend(NetworkResult.Success(emptyList()))
                }
                else -> {
                    try {
                        val filteredOrders = snapshot.documents
                            .mapNotNull { document -> 
                                document.toObject(Order::class.java)
                            }
                            .filter { order -> 
                                order.items.any { item ->
                                    item.orderStatus == status && item.product.partnerId == userId
                                }
                            }

                        trySend(NetworkResult.Success(filteredOrders))
                        
                        logTag?.let { tag ->
                            Log.d(tag, filteredOrders.toString())
                        }
                    } catch (e: Exception) {
                        trySend(NetworkResult.Error("Error processing orders: ${e.message}"))
                    }
                }
            }
        }

        awaitClose { listener.remove() }
    }

    suspend fun setOrderStateInOrder(order: Order, status: OrderStatus): NetworkResult<Unit> {
        return try {
            val batch = db.batch()
            val globalOrderDoc = db.collection(ORDERS).document(order.orderId)
            val globalSnapshot = globalOrderDoc.get().await()
            
            val fullOrder = globalSnapshot.toObject(Order::class.java)
                ?: return NetworkResult.Error("Order not found")

            val updatedItems = updateOrderItemsStatus(fullOrder.items, status)
            val updatedGlobalOrder = fullOrder.copy(items = updatedItems)

            // Update all references in batch
            updateOrderReferences(batch, order, updatedGlobalOrder, updatedItems)
            
            batch.commit().await()
            NetworkResult.Success(Unit)
            
        } catch (e: Exception) {
            NetworkResult.Error("Failed to update order status: ${e.message}")
        }
    }

    private fun updateOrderItemsStatus(items: List<CartProduct>, status: OrderStatus): List<CartProduct> {
        return items.map { item ->
            if (item.product.partnerId == userId) {
                item.copy(orderStatus = status)
            } else {
                item
            }
        }
    }

    private fun updateOrderReferences(
        batch: com.google.firebase.firestore.WriteBatch,
        order: Order,
        updatedGlobalOrder: Order,
        updatedItems: List<CartProduct>
    ) {
        val globalRef = db.collection(ORDERS).document(order.orderId)
        val userRef = db.collection(USERS).document(order.userId).collection(ORDERS).document(order.orderId)
        val partnerRef = orderRef.document(order.orderId)

        // Update global reference
        batch.set(globalRef, updatedGlobalOrder.toMap(), SetOptions.merge())
        
        // Update user reference
        batch.set(userRef, updatedGlobalOrder.toMap(), SetOptions.merge())
        
        // Update partner reference with filtered items
        val sellerOrder = updatedGlobalOrder.copy(
            items = updatedItems.filter { it.product.partnerId == userId }
        )
        batch.set(partnerRef, sellerOrder.toMap(), SetOptions.merge())
    }

    // Extension functions for mapping objects to Maps
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