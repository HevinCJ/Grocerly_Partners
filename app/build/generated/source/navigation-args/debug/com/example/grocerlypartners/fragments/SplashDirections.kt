package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class SplashDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionSplashToGrocerlyPartnersMainnav(): NavDirections = ActionOnlyNavDirections(R.id.action_splash_to_grocerly_partners_mainnav)

    @CheckResult
    public fun actionSplashToGrocerlyPartnersAuthnav(): NavDirections = ActionOnlyNavDirections(R.id.action_splash_to_grocerly_partners_authnav)
  }
}
