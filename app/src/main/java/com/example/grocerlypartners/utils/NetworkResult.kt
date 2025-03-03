package com.example.grocerlypartners.utils

sealed class NetworkResult<T>(val data:T?=null,val message: String?=null) {
    class Loading<T>(): NetworkResult<T>()
    class Success<T>(data:T): NetworkResult<T>(data)
    class Error<T>(message: String?): NetworkResult<T>(null,message)
    class UnSpecified<T>(): NetworkResult<T>()
}