package com.example.grocerlypartners.model// You can place this in a model or state package

data class SalesComparisonResult(
    val percentageChange: Double,
    val status: SalesStatus
)

enum class SalesStatus {
    INCREASE,
    DECREASE,
    NO_CHANGE,
    NO_PRIOR_DATA
}