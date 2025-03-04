package com.example.grocerlypartners.utils

import android.net.Uri
import android.util.Patterns
import com.example.grocerlypartners.model.OfferItem

fun validateOffer(offerItem: OfferItem):OfferValidation{

    val hexColorPattern = "^#(?:[0-9a-fA-F]{6}|[0-9a-fA-F]{8})$".toRegex()

    if (offerItem.offerImage.isEmpty()) return OfferValidation.Failure("Please Upload an Image ")

    if (isValidImageUrl(offerItem)) return OfferValidation.Failure("Please Upload valid Image url ")

    if (offerItem.buttonText.isEmpty()) return OfferValidation.Failure("Please fill Button Quote")

    if (offerItem.offerBgColor.isEmpty()) return OfferValidation.Failure("Background Color should be provided")

    if (!offerItem.offerBgColor.matches(hexColorPattern)) return OfferValidation.Failure("Invalid Background Color format")

    if (offerItem.buttonBgColor.isEmpty()) return OfferValidation.Failure("Button Background Color should be provided")

    if (!offerItem.buttonBgColor.matches(hexColorPattern)) return OfferValidation.Failure("Invalid Button Background Color Format")

    if (offerItem.buttonTxtColor.isEmpty()) return OfferValidation.Failure("Button Text  Color should be provided")

    if (!offerItem.buttonTxtColor.matches(hexColorPattern)) return OfferValidation.Failure("Invalid Button Text  Color Format")

    if (offerItem.descriptionTextColor.isEmpty()) return OfferValidation.Failure("Description Text Color should be provided")

    if (!offerItem.descriptionTextColor.matches(hexColorPattern)) return OfferValidation.Failure("Invalid Description Text Color Format")

    if (offerItem.descriptionText.isEmpty()) return OfferValidation.Failure("Description Cannot be empty")

    return OfferValidation.Success
}

fun isValidImageUrl(offerItem: OfferItem):Boolean{

    val uri = Uri.parse(offerItem.offerImage).toString()

    if (!Patterns.WEB_URL.matcher(uri).matches()) return false

    val imageExtensions = listOf("jpg", "jpeg", "png", "gif", "webp", "bmp")

    val fileExtension = uri.substringAfterLast('.', "").lowercase()
    return fileExtension in imageExtensions

}