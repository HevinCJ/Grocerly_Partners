package com.example.grocerlypartners.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.model.BusinessUiState
import com.example.grocerlypartners.model.SalesComparisonResult
import com.example.grocerlypartners.repository.BusinessRepoImpl
import com.example.grocerlypartners.utils.DashboardFilter
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.NetworkUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject


@HiltViewModel
class BusinessViewModel @Inject constructor(application: Application,private val businessRepoImpl: BusinessRepoImpl)  : AndroidViewModel(application) {

    private val _businessUiState = MutableStateFlow<BusinessUiState?>(null)
    val businessUiState get() = _businessUiState.asStateFlow()


    private val totalActiveOrderSize = MutableStateFlow<NetworkResult<Int>>(NetworkResult.UnSpecified())
    private val totalActiveOrderAmount = MutableStateFlow<NetworkResult<Long>>(NetworkResult.UnSpecified())
    private val cancelledOrderSize = MutableStateFlow<NetworkResult<Int>>(NetworkResult.UnSpecified())
    private val cancelledOrderAmount = MutableStateFlow<NetworkResult<Long>>(NetworkResult.UnSpecified())

    private val totalSalesComparison = MutableStateFlow<NetworkResult<SalesComparisonResult>>(NetworkResult.UnSpecified())
    private val totalSalesComparisonSize = MutableStateFlow<NetworkResult<SalesComparisonResult>>(NetworkResult.UnSpecified())
    private val totalCancelledSales = MutableStateFlow<NetworkResult<SalesComparisonResult>>(NetworkResult.UnSpecified())
    private val totalCancelledSalesSize = MutableStateFlow<NetworkResult<SalesComparisonResult>>(NetworkResult.UnSpecified())



    init {
        // loadDataWithFilter(DashboardFilter.Today)
        fetchActiveSize(0,0)
        fetchActiveAmount(0,0)
        fetchCancelledSize(0,0)
        fetchCancelledAmount(0,0)
        fetchSalesComparison(0,0,0,0)
        fetchCompareTotalAmountSize(0,0,0,0)
        fetchCompareCancelledSize(0,0,0,0)
        fetchTotalCancelledAmount(0,0,0,0)

        merge(totalActiveOrderSize.map { BusinessUiState.TotalOrderSize(it) },totalActiveOrderAmount.map { BusinessUiState.TotalActiveOrderAmount(it) },cancelledOrderSize.map { BusinessUiState.CancelledOrderSize(it) },cancelledOrderAmount.map { BusinessUiState.CancelledOrderAmount(it) },totalSalesComparison.map { BusinessUiState.SalesComparison(it) },totalSalesComparisonSize.map { BusinessUiState.SalesComparisonSize(it) },totalCancelledSales.map { BusinessUiState.SalesComparisonCancelled(it) },totalCancelledSalesSize.map { BusinessUiState.SalesComparisonCancelledSize(it) }).onEach {
            _businessUiState.value = it
        }.launchIn(viewModelScope)

    }



    fun loadDataWithFilter(filter: DashboardFilter){
        viewModelScope.launch {
            loadDataForFilter(DashboardFilter.Today)
        }
    }


    fun fetchCompareTotalAmountSize(currentStartTime: Long?,currentEndTime: Long?,previousStartTime: Long?,previousEndTime: Long?){
        viewModelScope.launch {
            compareTotalOrderAmountSize(currentStartTime,currentEndTime,previousStartTime,previousEndTime)
        }
    }

    fun fetchCompareCancelledSize(currentStartTime: Long?,currentEndTime: Long?,previousStartTime: Long?,previousEndTime: Long?){
        viewModelScope.launch {
            compareTotalCancelledOrderSize(currentStartTime,currentEndTime,previousStartTime,previousEndTime)
        }
    }


    fun fetchTotalCancelledAmount(currentStartTime: Long?,currentEndTime: Long?,previousStartTime: Long?,previousEndTime: Long?){
        viewModelScope.launch {
             compareTotalCancelledOrderAmount(currentStartTime,currentEndTime,previousStartTime,previousEndTime)
        }
    }



    fun fetchActiveSize(startTime: Long?,endTime: Long?){
        viewModelScope.launch {
            fetchTotalActiveOrderSize(startTime,endTime)
        }
    }

    fun fetchActiveAmount(startTime: Long?,endTime: Long?){
        viewModelScope.launch {
            fetchTotalActiveOrderAmount(startTime,endTime)
        }
    }

    fun fetchCancelledSize(startTime: Long?,endTime: Long?){
        viewModelScope.launch {
            fetchTotalCancelledOrderSize(startTime,endTime)
        }
    }

    fun fetchCancelledAmount(startTime: Long?,endTime: Long?){
        viewModelScope.launch {
            fetchTotalCancelledOrderAmount(startTime,endTime)
        }
    }


    fun fetchSalesComparison(currentStartTime: Long?,currentEndTime: Long?,previousStartTime: Long?,previousEndTime: Long?){
        viewModelScope.launch {
            fetchTotalSalesComparison(currentStartTime,currentEndTime,previousStartTime,previousEndTime)
        }

    }



    suspend fun fetchTotalActiveOrderSize(startTime:Long?,endTime:Long?){
      if (NetworkUtils.isNetworkAvailable(getApplication())){
          val result =  businessRepoImpl.fetchTotalOrdersSize(startTime?: 0L,endTime?: 0L)
          totalActiveOrderSize.emit(result)
      }else{
          totalActiveOrderSize.emit(NetworkResult.Error("Enable Wifi or Mobile data"))
      }
    }

    suspend fun fetchTotalActiveOrderAmount(startTime:Long?,endTime:Long?){
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val result =  businessRepoImpl.fetchTotalAmountActiveOrders(startTime?: 0L,endTime?: 0L)
            totalActiveOrderAmount.emit(result)
        }
    }

    suspend fun fetchTotalCancelledOrderSize(startTime:Long?,endTime:Long?){
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val result =  businessRepoImpl.fetchCancelledOrdersSize(startTime?: 0L,endTime?: 0L)
            cancelledOrderSize.emit(result)
        }
    }

    suspend fun fetchTotalCancelledOrderAmount(startTime:Long?,endTime:Long?){
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val result =  businessRepoImpl.fetchTotalOrderLoss(startTime?: 0L,endTime?: 0L)
            cancelledOrderAmount.emit(result)
        }
    }



    private suspend fun loadDataForFilter(filter: DashboardFilter) {
        coroutineScope {

            val activeSizeDeferred: Deferred<NetworkResult<Int>>
            val activeAmountDeferred: Deferred<NetworkResult<Long>>
            val cancelledSizeDeferred: Deferred<NetworkResult<Int>>
            val cancelledAmountDeferred: Deferred<NetworkResult<Long>>

            val comparisonCancelledAmountDeferred: Deferred<NetworkResult<SalesComparisonResult>>
            val comparisonCancelledSizeDeferred: Deferred<NetworkResult<SalesComparisonResult>>
            val comparisonActiveOrderAmountDeferred: Deferred<NetworkResult<SalesComparisonResult>>
            val comparisonActiveOrderSizeDeferred: Deferred<NetworkResult<SalesComparisonResult>>


            when (filter) {
                is DashboardFilter.Today -> {

                    activeSizeDeferred = async { businessRepoImpl.fetchTotalOrdersSize() }
                    activeAmountDeferred = async { businessRepoImpl.fetchTotalAmountActiveOrders() }
                    cancelledAmountDeferred = async { businessRepoImpl.fetchTotalOrderLoss() }
                    cancelledSizeDeferred = async { businessRepoImpl.fetchCancelledOrdersSize() }

                    comparisonCancelledSizeDeferred = async { businessRepoImpl.compareCancelledOrderSize() }
                    comparisonActiveOrderAmountDeferred = async { businessRepoImpl.compareSalesAmount() }
                    comparisonCancelledAmountDeferred = async { businessRepoImpl.compareCancelledOrders() }
                    comparisonActiveOrderSizeDeferred = async { businessRepoImpl.compareOrderSize() }
                }

                is DashboardFilter.Yesterday -> {

                    val zoneId = ZoneId.of("Asia/Kolkata")
                    val today = LocalDate.now(zoneId)
                    val yesterday = today.minusDays(1)
                    val dayBefore = yesterday.minusDays(1)

                    val yesterdayStart = yesterday.atStartOfDay(zoneId).toInstant().toEpochMilli()
                    val yesterdayEnd = today.atStartOfDay(zoneId).toInstant().toEpochMilli() - 1

                    val dayBeforeStart = dayBefore.atStartOfDay(zoneId).toInstant().toEpochMilli()
                    val dayBeforeEnd = yesterday.atStartOfDay(zoneId).toInstant().toEpochMilli() - 1

                    activeSizeDeferred = async { businessRepoImpl.fetchTotalOrdersSize(yesterdayStart,yesterdayEnd) }
                    activeAmountDeferred = async { businessRepoImpl.fetchTotalAmountActiveOrders(yesterdayStart,yesterdayEnd) }
                    cancelledAmountDeferred = async { businessRepoImpl.fetchTotalOrderLoss(yesterdayStart,yesterdayEnd) }
                    cancelledSizeDeferred = async { businessRepoImpl.fetchCancelledOrdersSize(yesterdayStart,yesterdayEnd) }

                    comparisonCancelledSizeDeferred = async { businessRepoImpl.compareCancelledOrderSize(yesterdayStart,yesterdayEnd,dayBeforeStart,dayBeforeEnd) }
                    comparisonActiveOrderAmountDeferred = async { businessRepoImpl.compareSalesAmount(yesterdayStart,yesterdayEnd,dayBeforeStart,dayBeforeEnd) }
                    comparisonCancelledAmountDeferred = async { businessRepoImpl.compareCancelledOrders(yesterdayStart,yesterdayEnd,dayBeforeStart,dayBeforeEnd) }
                    comparisonActiveOrderSizeDeferred = async { businessRepoImpl.compareOrderSize(yesterdayStart,yesterdayEnd,dayBeforeStart,dayBeforeEnd) }
                }

                is DashboardFilter.Custom -> {

                    val currentStartTime = filter.startTime
                    val currentEndTime = filter.endTime

                    val duration = currentEndTime - currentStartTime
                    val previousEndTime = currentStartTime - 1
                    val previousStartTime = previousEndTime - duration

                    activeSizeDeferred = async { businessRepoImpl.fetchTotalOrdersSize(currentStartTime,currentEndTime) }
                    activeAmountDeferred = async { businessRepoImpl.fetchTotalAmountActiveOrders(currentStartTime,currentEndTime) }
                    cancelledAmountDeferred = async { businessRepoImpl.fetchTotalOrderLoss(currentStartTime,currentEndTime) }
                    cancelledSizeDeferred = async { businessRepoImpl.fetchCancelledOrdersSize(currentStartTime,currentEndTime) }

                    comparisonCancelledSizeDeferred = async { businessRepoImpl.compareCancelledOrderSize(currentStartTime,currentEndTime,previousStartTime,previousEndTime) }
                    comparisonActiveOrderAmountDeferred = async { businessRepoImpl.compareSalesAmount(currentStartTime,currentEndTime,previousStartTime,previousEndTime) }
                    comparisonCancelledAmountDeferred = async { businessRepoImpl.compareCancelledOrders(currentStartTime,currentEndTime,previousStartTime,previousEndTime) }
                    comparisonActiveOrderSizeDeferred = async { businessRepoImpl.compareOrderSize(currentStartTime,currentEndTime,previousStartTime,previousEndTime) }
                }
            }


            val activeSizeResult = activeSizeDeferred.await()
            val activeAmountResult = activeAmountDeferred.await()
            val comparisonResult = comparisonActiveOrderAmountDeferred.await()
        }

    }






    suspend fun fetchTotalSalesComparison(
        currentStartTime: Long?,
        currentEndTime: Long?,
        previousStartTime: Long?,
        previousEndTime: Long?
    ) {
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val comparisonResult = businessRepoImpl.compareSalesAmount(currentStartTime?: 0L,currentEndTime?: 0L,previousStartTime?: 0L,previousEndTime?: 0L)
            totalSalesComparison.emit(comparisonResult)
        }else{
            totalSalesComparison.emit(NetworkResult.Error("Enable Wifi or Mobile data"))
        }
    }

    suspend fun compareTotalOrderAmountSize(startTime:Long?,endTime:Long?,previousStartTime: Long?,previousEndTime: Long?){
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val result =  businessRepoImpl.compareOrderSize(startTime?: 0L,endTime?: 0L,previousStartTime?: 0L,previousEndTime?: 0L)
            totalSalesComparisonSize.emit(result)
        }
    }


    suspend fun compareTotalCancelledOrderAmount(startTime:Long?,endTime:Long?,previousStartTime: Long?,previousEndTime: Long?){
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val result =  businessRepoImpl.compareCancelledOrders(startTime?: 0L,endTime?: 0L,previousStartTime?: 0L,previousEndTime?: 0L)
            totalCancelledSales.emit(result)
        }
    }

    suspend fun compareTotalCancelledOrderSize(startTime:Long?,endTime:Long?,previousStartTime: Long?,previousEndTime: Long?){
        if (NetworkUtils.isNetworkAvailable(getApplication())){
            val result =  businessRepoImpl.compareCancelledOrderSize(startTime?: 0L,endTime?: 0L,previousStartTime?: 0L,previousEndTime?: 0L)
            totalCancelledSalesSize.emit(result)
        }
    }



}