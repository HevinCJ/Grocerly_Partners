package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class UpdateProductDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionUpdateProductToProducts(): NavDirections = ActionOnlyNavDirections(R.id.action_updateProduct_to_products)
  }
}
