package com.example.grocerlypartners.model

import com.example.grocerlypartners.utils.ProductCategory

data class Product(
    val image:String?,
    val itemName:String,
    val itemPrice:Int?,
    val category: ProductCategory,
    val itemRating:Int ?= 0,
    val totalRating:Int ?= 0
){
    constructor():this("","",null, ProductCategory.selectcatgory,null,null)
}
