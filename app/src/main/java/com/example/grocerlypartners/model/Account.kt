package com.example.grocerlypartners.model

data class Account(
    val firstName:String,
    val lastName:String,
    val email:String,
    val imageUrl:String = " "
){
    constructor():this("","","","")
}
