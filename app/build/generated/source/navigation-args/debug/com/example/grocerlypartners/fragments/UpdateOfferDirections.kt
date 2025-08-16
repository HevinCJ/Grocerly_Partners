package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class UpdateOfferDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionUpdateOfferToOffers(): NavDirections = ActionOnlyNavDirections(R.id.action_updateOffer_to_offers)
  }
}
