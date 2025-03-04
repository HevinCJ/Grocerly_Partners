package com.example.grocerlypartners.utils

import android.util.Patterns

fun validateEmail(email: String): RegisterValidation{

    if (email.isEmpty()) return RegisterValidation.Failure("Required: Email cannot be empty")

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) return RegisterValidation.Failure("Invalid Email Format")

    return RegisterValidation.Success()
}


fun validatePassword(password: String): RegisterValidation{

    if (password.isEmpty()) return RegisterValidation.Failure("Required:Password cannot be empty")

    if (password.length<6) return RegisterValidation.Failure("Password length must be 6 character")

    return RegisterValidation.Success()

}

fun validateName(name: String): RegisterValidation{
    if(name.isEmpty()) return RegisterValidation.Failure("Required:Name cannot be empty")

    if(name.length<5) return RegisterValidation.Failure("Name must contain 5 character")

    return RegisterValidation.Success()
}