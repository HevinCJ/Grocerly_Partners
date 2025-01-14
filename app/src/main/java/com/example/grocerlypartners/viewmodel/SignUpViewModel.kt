package com.example.grocerlypartners.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.utils.Account
import com.example.grocerlypartners.utils.Constants.ACCOUNTS
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.RegisterValidation
import com.example.grocerlypartners.utils.SignUpState
import com.example.grocerlypartners.utils.validateEmail
import com.example.grocerlypartners.utils.validateName
import com.example.grocerlypartners.utils.validatePassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(private val auth: FirebaseAuth,private val db: FirebaseFirestore): ViewModel() {

    private val _isSigned = MutableSharedFlow<NetworkResult<FirebaseUser>>()
    val isSigned: Flow<NetworkResult<FirebaseUser>> get() = _isSigned

    private val _signUpState = Channel<SignUpState>()
    val signUpState: Flow<SignUpState> get() = _signUpState.receiveAsFlow()


    fun performSignUpForPartner(name: String,email: String,password: String){
        viewModelScope.launch{
            if (isValidated(name,email,password)){
                performSignUp(name,email,password)
            }else{
                emitValidationErrors(name,email,password)
            }
        }
    }

    private fun isValidated(name:String,email: String,password: String): Boolean{
        val isNameValidated = validateName(name)
        val isEmailValidated = validateEmail(email)
        val isPasswordValidated = validatePassword(password)

        val validationOk = isNameValidated is RegisterValidation.Success && isEmailValidated is RegisterValidation.Success && isPasswordValidated is RegisterValidation.Success
        return validationOk
    }


    private suspend fun performSignUp(name: String,email: String,password: String){
        try {
            _isSigned.emit(NetworkResult.Loading())

            val signedUser =  auth.createUserWithEmailAndPassword(email,password).await()
            val user = signedUser.user
            val isSaved = saveAccountToDb(Account(name,"",email,""))

            if (user!=null && isSaved){

                _isSigned.emit(NetworkResult.Success(user))

            } else {
                _isSigned.emit(NetworkResult.Error("Unable to SignIn , Please try later.."))
            }

        }catch (e: Exception){
            _isSigned.emit(NetworkResult.Error(e.message))
        }
    }

    private suspend fun saveAccountToDb(account: Account): Boolean {
        val userId = auth.currentUser?.uid.toString()
        return try {
            db.collection(ACCOUNTS)
                .document(userId)
                .set(account)
                .await()
            true
        }catch (e: Exception){
            false
        }
    }

    private suspend fun emitValidationErrors(name: String,email: String,password: String){
        val signUpState = SignUpState(validateName(name),validateEmail(email),validatePassword(password))
        _signUpState.send(signUpState)
    }

}