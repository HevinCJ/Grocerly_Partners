package com.example.grocerlypartners.utils

enum class Reason(val reason:String) {
    ReasonNotDepicted("Reason is not depicted"),
    outofstock("some or all items is out of stock"),
    unabletodeliver("order is unable to deliver to the given address"),
    pickupundone("pickup is not done by delivery agent"),
    selleroffline("our warehouse is currently offline")
}