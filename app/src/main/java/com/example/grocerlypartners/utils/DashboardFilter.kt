package com.example.grocerlypartners.utils

sealed class DashboardFilter {
    object Today : DashboardFilter()
    object Yesterday : DashboardFilter()
    data class Custom(val startTime: Long, val endTime: Long) : DashboardFilter()
}