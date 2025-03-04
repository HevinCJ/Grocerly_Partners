package com.example.grocerlypartners.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class OfferItem(
    val offerId:String,
    val offerImage: String,
    val offerBgColor: String,
    val buttonText: String,
    val buttonBgColor: String,
    val buttonTxtColor:String,
    val descriptionText: String,
    val descriptionTextColor: String
):Parcelable{
    constructor():this("","","","","","","","")
}
