package com.example.grocerlypartners.utils


sealed class OfferValidation() {
    data object Success:OfferValidation()
    class Failure(val message:String):OfferValidation()
}

data class OfferState(
    val offer:OfferValidation
)