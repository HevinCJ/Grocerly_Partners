package com.example.grocerlypartners.repository

import android.util.Log
import com.example.grocerlypartners.model.SalesComparisonResult
import com.example.grocerlypartners.model.SalesStatus
import com.example.grocerlypartners.utils.Constants.ORDERS
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject

@ActivityRetainedScoped
class BusinessRepoImpl @Inject constructor(private val auth: FirebaseAuth,private val db: FirebaseFirestore,private val ordersRepoImpl: OrdersRepoImpl) {

    private val userId = auth.currentUser?.uid.toString()
    private val orderRef = db.collection(PARTNERS).document(userId).collection( ORDERS)

    suspend fun fetchCancelledOrdersSize(
        startTime: Long = 0L,
        endTime: Long = 0L
    ): NetworkResult<Int> {
        try {
            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId).atStartOfDay(zoneId).toInstant().toEpochMilli()

            val effectiveStartTime = if (startTime == 0L) todayStartTime else startTime
            val effectiveEndTime = if (endTime == 0L) System.currentTimeMillis() else endTime


            val networkResult = ordersRepoImpl.fetchCancelledItems().filter { it !is NetworkResult.Loading }.first()
            Log.d("cancelledorderssize",networkResult.data?.values.toString())

            return when (networkResult) {
                is NetworkResult.Success -> {
                    if (networkResult.data.isNullOrEmpty()) {
                        return NetworkResult.Success(0)
                    }

                    val size = networkResult.data.values
                        .flatten()
                        .count { (it.cancellationInfo.cancelledAt) in effectiveStartTime..effectiveEndTime }

                    NetworkResult.Success(size)
                }

                is NetworkResult.Error -> NetworkResult.Error(
                    networkResult.message ?: "Failed to fetch cancelled orders"
                )

                is NetworkResult.Loading -> NetworkResult.Loading()
                is NetworkResult.UnSpecified -> NetworkResult.UnSpecified()
            }


        } catch (e: Exception) {
            return NetworkResult.Error(e.message ?: "Failed to fetch cancelled orders")
        }
    }



    suspend fun fetchTotalOrderLoss(startTime: Long = 0L,endTime: Long = 0L): NetworkResult<Long> {
        try {


            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId).atStartOfDay(zoneId).toInstant().toEpochMilli()


            val effectiveStartTime = if (startTime == 0L) todayStartTime else startTime
            val effectiveEndTime = if (endTime == 0L) System.currentTimeMillis() else endTime

            val networkResult = ordersRepoImpl.fetchCancelledItems().filter { it !is NetworkResult.Loading }.first()
            Log.d("totalorderloss",networkResult.data.toString())



            return when (networkResult) {
                is NetworkResult.Error -> NetworkResult.Error(
                    networkResult.message ?: "Unable to get total order loss"
                )

                is NetworkResult.Loading -> NetworkResult.Loading()
                is NetworkResult.UnSpecified -> NetworkResult.UnSpecified()
                is NetworkResult.Success -> {

                    if (networkResult.data.isNullOrEmpty()) {
                        return NetworkResult.Success(0L)
                    }

                    val totalAmount: Long = networkResult.data.values.flatten()
                        .filter { (it.cancellationInfo.cancelledAt) in effectiveStartTime..effectiveEndTime }
                        .sumOf { cartProduct ->
                            (cartProduct.product.itemPrice ?: 0L).toLong() * cartProduct.quantity
                        }

                    NetworkResult.Success(totalAmount)
                }
            }

        } catch (e: Exception) {
            return NetworkResult.Error(e.message ?: "Unable to get total order loss")
        }
    }


    suspend fun fetchTotalOrdersSize(startTime: Long = 0L,endTime: Long = 0L):NetworkResult<Int>{
        try {

            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId).atStartOfDay(zoneId).toInstant().toEpochMilli()

            val effectiveStartTime = if (startTime == 0L) todayStartTime else startTime
            val effectiveEndTime = if (endTime == 0L) System.currentTimeMillis() else endTime

            val networkResult =  ordersRepoImpl.fetchAllActiveOrders().filter { it !is NetworkResult.Loading }.first()

            return when (networkResult) {
                is NetworkResult.Success -> {

                    if (networkResult.data.isNullOrEmpty()) {
                        return NetworkResult.Success(0)
                    }

                    val size = networkResult.data.count { it.timestamp in effectiveStartTime .. effectiveEndTime }
                    NetworkResult.Success(size)

                }
                is NetworkResult.Error -> NetworkResult.Error(networkResult.message ?: "Failed to fetch cancelled orders")
                is NetworkResult.Loading -> NetworkResult.Loading()
                is NetworkResult.UnSpecified -> NetworkResult.UnSpecified()
            }

        }catch (e: Exception){
            return NetworkResult.Error(e.message ?: "Failed to fetch cancelled orders")
        }
    }

    suspend fun fetchTotalAmountActiveOrders(startTime: Long = 0L,endTime: Long = 0L): NetworkResult<Long> {
       return try {
           val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId).atStartOfDay(zoneId).toInstant().toEpochMilli()

            val effectiveStartTime = if (startTime == 0L) todayStartTime else startTime
            val effectiveEndTime = if (endTime == 0L) System.currentTimeMillis() else endTime


            when (val networkResult = ordersRepoImpl.fetchAllActiveOrders().filter { it !is NetworkResult.Loading }.first()) {
                is NetworkResult.Success -> {
                    val orders = networkResult.data.orEmpty()
                    if (orders.isEmpty()) {
                        NetworkResult.Success(0L)
                    } else {
                        val totalAmount = orders
                            .filter { it.timestamp in effectiveStartTime..effectiveEndTime }
                            .flatMap { it.items }
                            .sumOf { (it.product.itemPrice ?: 0L).toLong() * it.quantity }
                        NetworkResult.Success(totalAmount)

                    }
                }
                is NetworkResult.Error -> NetworkResult.Error(
                    networkResult.message ?: "Unable to get total order loss"
                )
                is NetworkResult.Loading -> NetworkResult.Loading()
                is NetworkResult.UnSpecified -> NetworkResult.UnSpecified()
            }

        } catch (e: Exception) {
            return NetworkResult.Error(e.message ?: "Unable to get total Amount")
        }
    }


    suspend fun compareSalesAmount(currentStartTime: Long = 0L, currentEndTime: Long = 0L, previousStartTime: Long = 0L, previousEndTime: Long = 0L): NetworkResult<SalesComparisonResult>{
        return try {

            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId)
            val yesterday = LocalDate.now(zoneId).minusDays(1)

            val effectiveCurrentStart = if (currentStartTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else currentStartTime

            val effectiveCurrentEnd = if (currentEndTime == 0L) {
                System.currentTimeMillis()
            } else currentEndTime


            val effectivePreviousStart = if (previousStartTime == 0L) {
                yesterday.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else previousStartTime

            val effectivePreviousEnd = if (previousEndTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli() - 1 // End of yesterday
            } else previousEndTime

            val (currentResult, previousResult) = coroutineScope {
                val currentDeferred = async { fetchTotalAmountActiveOrders(effectiveCurrentStart, effectiveCurrentEnd) }
                val previousDeferred = async { fetchTotalAmountActiveOrders(effectivePreviousStart, effectivePreviousEnd) }
                currentDeferred.await() to previousDeferred.await()
            }

            if (currentResult is NetworkResult.Error) return NetworkResult.Error("Unable to get current Sales data")
            if (previousResult is NetworkResult.Error) return NetworkResult.Error("Unable to get previous Sales data")

            val currentSales = (currentResult as NetworkResult.Success).data ?: 0
            val previousSales = (previousResult as NetworkResult.Success).data ?: 0

            val (percentage, status) = when {
                previousSales > 0L -> {
                    val change = ((currentSales.toDouble() - previousSales) / previousSales) * 100.0
                    val status = if (change > 0) SalesStatus.INCREASE else if (change < 0) SalesStatus.DECREASE else SalesStatus.NO_CHANGE
                    change to status
                }
                previousSales == 0L && currentSales > 0L -> 100.0 to SalesStatus.INCREASE
                else -> 0.0 to SalesStatus.NO_PRIOR_DATA
            }

            NetworkResult.Success(
                SalesComparisonResult(
                    percentageChange = percentage,
                    status = status
                )
            )

        }catch (e: Exception){
           return NetworkResult.Error(e.message ?: "Failed to get Sales data")
        }
    }

    suspend fun compareOrderSize(currentStartTime: Long = 0L, currentEndTime: Long = 0L, previousStartTime: Long = 0L, previousEndTime: Long = 0L): NetworkResult<SalesComparisonResult>{
        return try {

            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId)
            val yesterday = LocalDate.now(zoneId).minusDays(1)

            val effectiveCurrentStart = if (currentStartTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else currentStartTime

            val effectiveCurrentEnd = if (currentEndTime == 0L) {
                System.currentTimeMillis()
            } else currentEndTime


            val effectivePreviousStart = if (previousStartTime == 0L) {
                yesterday.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else previousStartTime

            val effectivePreviousEnd = if (previousEndTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli() - 1 // End of yesterday
            } else previousEndTime

            val (currentResult, previousResult) = coroutineScope {
                val currentDeferred = async { fetchTotalOrdersSize(effectiveCurrentStart, effectiveCurrentEnd) }
                val previousDeferred = async { fetchTotalOrdersSize(effectivePreviousStart, effectivePreviousEnd) }
                currentDeferred.await() to previousDeferred.await()
            }

            if (currentResult is NetworkResult.Error) return NetworkResult.Error("Unable to get current Sales data")
            if (previousResult is NetworkResult.Error) return NetworkResult.Error("Unable to get previous Sales data")

            val currentSales = (currentResult as NetworkResult.Success).data ?: 0
            val previousSales = (previousResult as NetworkResult.Success).data ?: 0

            val (percentage, status) = when {
                previousSales > 0 -> {
                    val change = ((currentSales.toDouble() - previousSales) / previousSales) * 100.0
                    val status = if (change > 0) SalesStatus.INCREASE else if (change < 0) SalesStatus.DECREASE else SalesStatus.NO_CHANGE
                    change to status
                }
                previousSales == 0 && currentSales > 0 -> 100.0 to SalesStatus.INCREASE
                else -> 0.0 to SalesStatus.NO_PRIOR_DATA
            }

            NetworkResult.Success(
                SalesComparisonResult(
                    percentageChange = percentage,
                    status = status
                )
            )

        }catch (e: Exception){
            return NetworkResult.Error(e.message ?: "Failed to get Sales data")
        }
    }


    suspend fun compareCancelledOrderSize(currentStartTime: Long = 0L, currentEndTime: Long = 0L, previousStartTime: Long = 0L, previousEndTime: Long = 0L): NetworkResult<SalesComparisonResult>{
        return try {

            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId)
            val yesterday = LocalDate.now(zoneId).minusDays(1)

            val effectiveCurrentStart = if (currentStartTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else currentStartTime

            val effectiveCurrentEnd = if (currentEndTime == 0L) {
                System.currentTimeMillis()
            } else currentEndTime


            val effectivePreviousStart = if (previousStartTime == 0L) {
                yesterday.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else previousStartTime

            val effectivePreviousEnd = if (previousEndTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli() - 1 // End of yesterday
            } else previousEndTime

            val (currentResult, previousResult) = coroutineScope {
                val currentDeferred = async { fetchCancelledOrdersSize(effectiveCurrentStart, effectiveCurrentEnd) }
                val previousDeferred = async { fetchCancelledOrdersSize(effectivePreviousStart, effectivePreviousEnd) }
                currentDeferred.await() to previousDeferred.await()
            }

            if (currentResult is NetworkResult.Error) return NetworkResult.Error("Unable to get current Sales data")
            if (previousResult is NetworkResult.Error) return NetworkResult.Error("Unable to get previous Sales data")

            val currentSales = (currentResult as NetworkResult.Success).data ?: 0
            val previousSales = (previousResult as NetworkResult.Success).data ?: 0

            val (percentage, status) = when {
                previousSales > 0 -> {
                    val change = ((currentSales - previousSales) / previousSales) * 100.0
                    Log.d("percentagegot",change.toString())
                    val status = if (change > 0) SalesStatus.INCREASE else if (change < 0) SalesStatus.DECREASE else SalesStatus.NO_CHANGE
                    change to status
                }
                previousSales == 0 && currentSales > 0 -> 100.0 to SalesStatus.INCREASE
                else -> 0.0 to SalesStatus.NO_PRIOR_DATA
            }

            NetworkResult.Success(
                SalesComparisonResult(
                    percentageChange = percentage,
                    status = status
                )
            )

        }catch (e: Exception){
            return NetworkResult.Error(e.message ?: "Failed to get Sales data")
        }
    }

    suspend fun compareCancelledOrders(currentStartTime: Long = 0L, currentEndTime: Long = 0L, previousStartTime: Long = 0L, previousEndTime: Long = 0L): NetworkResult<SalesComparisonResult>{
        return try {

            val zoneId = ZoneId.of("Asia/Kolkata")
            val todayStartTime = LocalDate.now(zoneId)
            val yesterday = LocalDate.now(zoneId).minusDays(1)

            val effectiveCurrentStart = if (currentStartTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else currentStartTime

            val effectiveCurrentEnd = if (currentEndTime == 0L) {
                System.currentTimeMillis()
            } else currentEndTime


            val effectivePreviousStart = if (previousStartTime == 0L) {
                yesterday.atStartOfDay(zoneId).toInstant().toEpochMilli()
            } else previousStartTime

            val effectivePreviousEnd = if (previousEndTime == 0L) {
                todayStartTime.atStartOfDay(zoneId).toInstant().toEpochMilli() - 1 // End of yesterday
            } else previousEndTime

            val (currentResult, previousResult) = coroutineScope {
                val currentDeferred = async { fetchTotalOrderLoss(effectiveCurrentStart, effectiveCurrentEnd) }
                val previousDeferred = async { fetchTotalOrderLoss(effectivePreviousStart, effectivePreviousEnd) }
                currentDeferred.await() to previousDeferred.await()
            }

            if (currentResult is NetworkResult.Error) return NetworkResult.Error("Unable to get current Sales data")
            if (previousResult is NetworkResult.Error) return NetworkResult.Error("Unable to get previous Sales data")

            val currentSales = (currentResult as NetworkResult.Success).data ?: 0
            val previousSales = (previousResult as NetworkResult.Success).data ?: 0

            val (percentage, status) = when {
                previousSales > 0 -> {
                    val change = ((currentSales.toDouble() - previousSales) / previousSales) * 100.0
                    val status = if (change > 0) SalesStatus.INCREASE else if (change < 0) SalesStatus.DECREASE else SalesStatus.NO_CHANGE
                    change to status
                }
                previousSales == 0L && currentSales > 0 -> 100.0 to SalesStatus.INCREASE
                else -> 0.0 to SalesStatus.NO_PRIOR_DATA
            }
            Log.d("SalesDebug", "Comparing Current: $currentSales vs Previous: $previousSales")
            Log.d("cancelledorderloss",percentage.toString())

            NetworkResult.Success(
                SalesComparisonResult(
                    percentageChange = percentage,
                    status = status
                )
            )


        }catch (e: Exception){
            return NetworkResult.Error(e.message ?: "Failed to get Sales data")
        }
    }

}