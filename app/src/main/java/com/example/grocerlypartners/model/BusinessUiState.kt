package com.example.grocerlypartners.model

import com.example.grocerlypartners.utils.NetworkResult

sealed class BusinessUiState {
    class TotalActiveOrderAmount(val totalAmount: NetworkResult<Long>): BusinessUiState()
    class TotalOrderSize(val totalSize: NetworkResult<Int>): BusinessUiState()
    class CancelledOrderAmount(val totalAmount: NetworkResult<Long>): BusinessUiState()
    class CancelledOrderSize(val totalSize: NetworkResult<Int>): BusinessUiState()
    class SalesComparison(val comparisonResult: NetworkResult<SalesComparisonResult>): BusinessUiState()
    class SalesComparisonSize(val comparisonResult:  NetworkResult<SalesComparisonResult>): BusinessUiState()
    class SalesComparisonCancelledSize(val comparisonResult:  NetworkResult<SalesComparisonResult>): BusinessUiState()
    class SalesComparisonCancelled(val comparisonResult:  NetworkResult<SalesComparisonResult>): BusinessUiState()
}