package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class AddProductDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionAddProductToProducts(): NavDirections = ActionOnlyNavDirections(R.id.action_addProduct_to_products)
  }
}
