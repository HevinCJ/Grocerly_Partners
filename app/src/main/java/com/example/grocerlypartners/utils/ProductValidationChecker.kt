package com.example.grocerlypartners.utils

import com.example.grocerlypartners.model.Product

fun validateProduct(product: Product):ProductValidation{

    if (product.image.isNullOrEmpty()) {return ProductValidation.failure("Please upload an  image")}

    if (product.itemName.isEmpty()) return ProductValidation.failure("Product Name is Mandatory")

    if (product.itemPrice ==null || product.itemPrice<= 0) return ProductValidation.failure("Product Price is Mandatory")

    if (product.category == ProductCategory.selectcatgory) return ProductValidation.failure("Please select a category")

    return ProductValidation.success

}