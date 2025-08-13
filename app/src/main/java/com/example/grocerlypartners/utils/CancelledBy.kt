package com.example.grocerlypartners.utils

enum class CancelledBy(val displayName: String) {
    NONE("None"),
    USER("User"),
    SELLER("Seller");

    override fun toString(): String = displayName
}