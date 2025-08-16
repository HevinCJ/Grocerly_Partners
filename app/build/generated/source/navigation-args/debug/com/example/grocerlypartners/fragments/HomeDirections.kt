package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R
import com.example.grocerlypartners.model.Product
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class HomeDirections private constructor() {
  private data class ActionProductsToUpdateProduct(
    public val product: Product,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_products_to_updateProduct

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Product::class.java)) {
          result.putParcelable("product", this.product as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Product::class.java)) {
          result.putSerializable("product", this.product as Serializable)
        } else {
          throw UnsupportedOperationException(Product::class.java.name + " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionProductsToAddProduct(): NavDirections = ActionOnlyNavDirections(R.id.action_products_to_addProduct)

    @CheckResult
    public fun actionProductsToUpdateProduct(product: Product): NavDirections = ActionProductsToUpdateProduct(product)

    @CheckResult
    public fun actionProductsToAddOffer(): NavDirections = ActionOnlyNavDirections(R.id.action_products_to_addOffer)
  }
}
