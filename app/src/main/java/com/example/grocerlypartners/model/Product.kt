package com.example.grocerlypartners.model

import android.os.Parcelable
import com.example.grocerlypartners.utils.ProductCategory
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val productId:String,
    val partnerId:String,
    val image:String?,
    val itemName:String,
    val itemPrice:Int?,
    val category: ProductCategory,
    val itemRating:Double ?= 5.0,
    val totalRating:Int ?= 0,
    val isOrdered: Boolean=false
) : Parcelable {
    constructor():this("","","","",null, ProductCategory.selectcatgory,null,null,false)
}
