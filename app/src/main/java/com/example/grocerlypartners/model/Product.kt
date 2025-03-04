package com.example.grocerlypartners.model

import android.os.Parcelable
import com.example.grocerlypartners.utils.ProductCategory
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val productId:String,
    val image:String?,
    val itemName:String,
    val itemPrice:Int?,
    val category: ProductCategory,
    val itemRating:Double ?= 5.0,
    val totalRating:Int ?= 0
) : Parcelable {
    constructor():this("","","",null, ProductCategory.selectcatgory,null,null)
}
