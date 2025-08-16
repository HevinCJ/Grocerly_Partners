package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class AddOfferDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionAddOfferToOffers(): NavDirections = ActionOnlyNavDirections(R.id.action_addOffer_to_offers)
  }
}
