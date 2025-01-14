package com.example.grocerlypartners.utils

sealed class RegisterValidation{
    class Success(): RegisterValidation()
    class Failure(val message: String): RegisterValidation()
}

data class SignUpState(
    val name: RegisterValidation,
    val email: RegisterValidation,
    val password: RegisterValidation
)

data class LoginState(
    val email: RegisterValidation,
    val password: RegisterValidation
)
