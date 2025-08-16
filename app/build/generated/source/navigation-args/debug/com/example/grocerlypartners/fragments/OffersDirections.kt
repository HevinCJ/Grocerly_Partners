package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.`annotation`.CheckResult
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R
import com.example.grocerlypartners.model.OfferItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class OffersDirections private constructor() {
  private data class ActionOffersToUpdateOffer(
    public val offer: OfferItem,
  ) : NavDirections {
    public override val actionId: Int = R.id.action_offers_to_updateOffer

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(OfferItem::class.java)) {
          result.putParcelable("offer", this.offer as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(OfferItem::class.java)) {
          result.putSerializable("offer", this.offer as Serializable)
        } else {
          throw UnsupportedOperationException(OfferItem::class.java.name + " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    @CheckResult
    public fun actionOffersToUpdateOffer(offer: OfferItem): NavDirections = ActionOffersToUpdateOffer(offer)
  }
}
