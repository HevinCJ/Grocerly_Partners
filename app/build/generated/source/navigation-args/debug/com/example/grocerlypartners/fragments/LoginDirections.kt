package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class LoginDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionLoginToSignUp(): NavDirections = ActionOnlyNavDirections(R.id.action_login_to_signUp)

    @CheckResult
    public fun actionLoginToMainnav(): NavDirections = ActionOnlyNavDirections(R.id.action_login_to_mainnav)
  }
}
