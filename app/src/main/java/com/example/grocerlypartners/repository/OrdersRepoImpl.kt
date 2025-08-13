package com.example.grocerlypartners.repository

import android.util.Log
import com.example.grocerlypartners.model.Address
import com.example.grocerlypartners.model.CancellationInfo
import com.example.grocerlypartners.model.CartProduct
import com.example.grocerlypartners.model.Order
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.CancellationStatus
import com.example.grocerlypartners.utils.CancelledBy
import com.example.grocerlypartners.utils.Constants.ORDERS
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.USERS
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OrderStatus
import com.google.android.play.integrity.internal.ac
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import okhttp3.internal.filterList
import javax.inject.Inject




@ActivityRetainedScoped
class OrdersRepoImpl @Inject constructor(private val auth: FirebaseAuth,private val db: FirebaseFirestore) {

    private val userId  = auth.currentUser?.uid.toString()
    private val orderRef = db.collection(PARTNERS).document(userId).collection(ORDERS)


    fun fetchPendingOrders(): Flow<NetworkResult<List<Order>>> = callbackFlow {
        trySend(NetworkResult.Loading())
       val listener =  orderRef.addSnapshotListener {snapshot,exception->


            if (exception!=null){
                trySend(NetworkResult.Error(exception.message))
                return@addSnapshotListener
            }

            if (snapshot==null||snapshot.isEmpty){
                trySend(NetworkResult.Success(emptyList()))
                return@addSnapshotListener
            }



           val pendingOrders = snapshot.documents
               .mapNotNull { it.toObject(Order::class.java) }
               .filter { it.items.any{it.product.partnerId == userId && it.orderStatus== OrderStatus.PENDING && it.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled  } }

           trySend(NetworkResult.Success(pendingOrders))
           Log.d("pendingorders", pendingOrders.toString())

        }

        awaitClose {
            listener.remove()
        }
    }

    fun fetchAcceptedOrders(): Flow<NetworkResult<List<Order>>> = callbackFlow {
        trySend(NetworkResult.Loading())
        val listener =  orderRef.addSnapshotListener {snapshot,exception->
            if (exception!=null){
                trySend(NetworkResult.Error(exception.message))
                return@addSnapshotListener
            }

            if (snapshot==null||snapshot.isEmpty){
                trySend(NetworkResult.Success(emptyList()))
                return@addSnapshotListener
            }


            val acceptedOrders = snapshot.documents
                .mapNotNull { it.toObject(Order::class.java) }
                .filter { order ->
                    val sellerItems = order.items.filter { it.product.partnerId == userId }
                    val hadReadyItems = sellerItems.any { it.orderStatus == OrderStatus. ACCEPTED}
                    val hasActiveReadyItems = sellerItems.any {
                        it.orderStatus == OrderStatus.ACCEPTED &&
                                it.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled
                    }
                    // Keep order if it had READY items, even if all are now cancelled
                    hadReadyItems && (hasActiveReadyItems || !hasActiveReadyItems)
                }
                .map { order ->
                    order.copy(
                        items = order.items.filter { item ->
                            item.product.partnerId == userId &&
                                    item.orderStatus == OrderStatus.ACCEPTED &&
                                    item.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled
                        }
                    )
                }



            trySend(NetworkResult.Success(acceptedOrders))
            Log.d("accepted", acceptedOrders.toString())

        }

        awaitClose {
            listener.remove()
        }
    }


    fun fetchReadyOrders(): Flow<NetworkResult<List<Order>>> = callbackFlow {
        trySend(NetworkResult.Loading())
        val listener =  orderRef.addSnapshotListener {snapshot,exception->
            if (exception!=null){
                trySend(NetworkResult.Error(exception.message))
                return@addSnapshotListener
            }

            if (snapshot==null||snapshot.isEmpty){
                trySend(NetworkResult.Success(emptyList()))
                return@addSnapshotListener
            }


            val readyOrders = snapshot.documents
                .mapNotNull { it.toObject(Order::class.java) }
                .filter { order ->
                    val sellerItems = order.items.filter { it.product.partnerId == userId }
                    val hadReadyItems = sellerItems.any { it.orderStatus == OrderStatus.READY }
                    val hasActiveReadyItems = sellerItems.any {
                        it.orderStatus == OrderStatus.READY &&
                                it.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled
                    }
                    // Keep order if it had READY items, even if all are now cancelled
                    hadReadyItems && (hasActiveReadyItems || !hasActiveReadyItems)
                }
                .map { order ->
                    order.copy(
                        items = order.items.filter { item ->
                            item.product.partnerId == userId &&
                                    item.orderStatus == OrderStatus.READY &&
                                    item.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled
                        }
                    )
                }

            trySend(NetworkResult.Success(readyOrders))
            Log.d("readyorders", readyOrders.toString())

        }

        awaitClose {
            listener.remove()
        }
    }

    fun fetchShippedOrders(): Flow<NetworkResult<List<Order>>> = callbackFlow {
        trySend(NetworkResult.Loading())
        val listener =  orderRef.addSnapshotListener {snapshot,exception->

            if (exception!=null){
                trySend(NetworkResult.Error(exception.message))
                return@addSnapshotListener
            }

            if (snapshot==null||snapshot.isEmpty){
                trySend(NetworkResult.Success(emptyList()))
                return@addSnapshotListener
            }


            snapshot.let {
                val shippedOrders = it.documents.mapNotNull { it.toObject(Order::class.java) }
                    .filter {order ->

                        val sellerItems = order.items.filter { it.product.partnerId == userId }
                        val hadShippedItems = sellerItems.any { it.orderStatus == OrderStatus.SHIPPED }

                        val activeShippedItems = sellerItems.any {
                            it.orderStatus == OrderStatus.SHIPPED&&
                                    it.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled
                        }

                        hadShippedItems && (activeShippedItems|| !activeShippedItems)
                    }

                    .map { order ->
                        order.copy(
                            items = order.items.filter {
                                it.product.partnerId == userId &&
                                        it.orderStatus == OrderStatus.SHIPPED &&
                                        it.cancellationInfo.cancellationStatus == CancellationStatus.Non_Cancelled
                            }
                        )
                    }
                trySend(NetworkResult.Success(shippedOrders))
            }

        }

        awaitClose {
            listener.remove()
        }
    }



    suspend fun cleanCancelledOrders(){
      try {
          val snapshot = orderRef.get().await()
          val clearCancelledBatch = db.batch()

          snapshot.documents.forEach { documentSnapshot ->

              val order = documentSnapshot.toObject(Order::class.java) ?: return@forEach

              val filteredItems = order.items.filterNot { item ->
                 item.product.partnerId == userId &&
                          item.orderStatus == OrderStatus.PENDING&&
                         item.cancellationInfo.cancellationStatus == CancellationStatus.Cancelled

              }
              Log.d("filterditems",filteredItems.toString())


              if (filteredItems.isEmpty()) {
                  clearCancelledBatch.delete(documentSnapshot.reference)
              } else if (filteredItems.size != order.items.size) {
                  clearCancelledBatch.update(
                      documentSnapshot.reference,
                      "items",
                      filteredItems
                  )
              }

          }

          clearCancelledBatch.commit().await()
      }catch (e: Exception){
          Log.d("cancelledexception",e.message.toString())
      }
    }


    suspend fun setOrderStateInOrder(order: Order,status: OrderStatus): NetworkResult<Unit> {
       return try {

           val batch = db.batch()
           val globalSnap = db.collection(ORDERS).document(order.orderId).get().await()

           val userRef = db.collection(USERS).document(order.userId).collection(ORDERS).document(order.orderId)
           val partnerRef = orderRef.document(order.orderId)
           val fullOrder = globalSnap.toObject(Order::class.java)
           val globalRef = db.collection(ORDERS).document(order.orderId)

           if (fullOrder == null) {
               return NetworkResult.Error("Order not found")
           }


           val updatedItems = fullOrder.items.map {
               if (it.product.partnerId == userId &&  it.cancellationInfo.cancellationStatus != CancellationStatus.Cancelled) {
                   it.copy(orderStatus = status)
               } else {
                   it
               }
           }

           val updatedGlobalOrder = fullOrder.copy(items = updatedItems)
           //updating global reference
           batch.set(globalRef,updatedGlobalOrder.toMap(),SetOptions.merge())
           //user reference
           batch.set(userRef,updatedGlobalOrder.toMap(),SetOptions.merge())
           //partner reference
           val sellerOrder = fullOrder.copy(items = updatedItems.filter { it.product.partnerId == userId })
           batch.set(partnerRef,sellerOrder.toMap(), SetOptions.merge())


           batch.commit().await()

           NetworkResult.Success(Unit)
        }catch (e: Exception){
            NetworkResult.Error(e.message)
        }
    }


    suspend fun deleteOrderFromFirebase(order: Order): NetworkResult<Unit>{
        return try {
            orderRef.document(order.orderId).delete().await()
            NetworkResult.Success(Unit)
        }catch (e: Exception){
            NetworkResult.Error(e.message.toString())
        }
    }


    suspend fun setCancellationStatus(order: Order,reason: String): NetworkResult<Unit>{
        return try {

            val batch = db.batch()

            val cancellationInfo = CancellationInfo(
                cancellationStatus = CancellationStatus.Cancelled,
                cancelledAt = System.currentTimeMillis(),
                cancelledBy = CancelledBy.SELLER,
                reason =reason
            )


            val updatedItems = order.items.map {
                if (it.product.partnerId ==userId && it.orderStatus != OrderStatus.SHIPPED&& it.orderStatus != OrderStatus.DELIVERED&& it.orderStatus != OrderStatus.OUTFORDELIVERY && it.cancellationInfo.cancellationStatus != CancellationStatus.Cancelled){
                    it.copy(
                        cancellationInfo = cancellationInfo
                    )
                }else{
                    it
                }
            }
            val updatedOrder = order.copy(items = updatedItems)

            val userRef = db.collection(USERS).document(order.userId).collection(ORDERS).document(order.orderId)
            val globalRef = db.collection(ORDERS).document(order.orderId)
            val partnerRef = orderRef.document(order.orderId)


            batch.set(userRef,updatedOrder.toMap(), SetOptions.merge())
            batch.set(globalRef,updatedOrder.toMap(), SetOptions.merge())

            val sellerOrder = updatedOrder.copy(items = updatedItems.filter { it.product.partnerId == userId })
            batch.set(partnerRef,sellerOrder.toMap(), SetOptions.merge())

            batch.commit().await()
            NetworkResult.Success(Unit)
        }catch (e: Exception){
            NetworkResult.Error(e.message)
        }
    }

    fun Order.toMap(): Map<String, Any> {
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


    fun CartProduct.toMap(): Map<String, Any?> {
        return mapOf(
            "product" to product,
            "quantity" to quantity,
            "deliveryDate" to deliveryDate,
            "deliveredDate" to deliveredDate,
            "orderStatus" to orderStatus,
            "cancellationInfo" to cancellationInfo.toMap()
        )
    }

    fun Product.toMap(): Map<String, Any?> {
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


    fun CancellationInfo.toMap(): Map<String, Any?> {
        return mapOf(
            "cancellationStatus" to cancellationStatus.name,
            "cancelledBy" to cancelledBy.name,
            "cancelledAt" to cancelledAt,
            "reason" to reason
        )
    }



}