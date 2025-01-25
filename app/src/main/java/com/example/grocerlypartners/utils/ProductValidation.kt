package com.example.grocerlypartners.utils

sealed class ProductValidation() {
    data object success:ProductValidation()
    class failure(val message:String):ProductValidation()
}

data class productValidationState(
    val product:ProductValidation
)