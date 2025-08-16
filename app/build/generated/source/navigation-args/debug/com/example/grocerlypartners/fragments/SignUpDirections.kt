package com.example.grocerlypartners.fragments

import androidx.`annotation`.CheckResult
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.grocerlypartners.R

public class SignUpDirections private constructor() {
  public companion object {
    @CheckResult
    public fun actionSignUpToLogin(): NavDirections = ActionOnlyNavDirections(R.id.action_signUp_to_login)
  }
}
