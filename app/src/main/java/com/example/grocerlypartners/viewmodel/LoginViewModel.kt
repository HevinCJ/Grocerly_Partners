package com.example.grocerlypartners.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.preferences.GrocerlyDataStore
import com.example.grocerlypartners.utils.LoginState
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.RegisterValidation
import com.example.grocerlypartners.utils.validateEmail
import com.example.grocerlypartners.utils.validatePassword
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (private val auth: FirebaseAuth,application: Application): AndroidViewModel(application) {

    private val _isloggedIn =MutableSharedFlow<NetworkResult<FirebaseUser>>()
    val isloggedIn: Flow<NetworkResult<FirebaseUser>> get() = _isloggedIn.asSharedFlow()

    private val _isValidated = Channel<LoginState>()
    val isValidated: Flow<LoginState> get() = _isValidated.receiveAsFlow()

    private val _isReseted = MutableSharedFlow<NetworkResult<String>>()
    val isReseted: Flow<NetworkResult<String>> get() = _isReseted.asSharedFlow()

    private val datastore = GrocerlyDataStore(application)

    val loginState = datastore.getLoginState().asLiveData()



    fun loginPartnerToFirebase(email: String,password: String){
        viewModelScope.launch{
           if (isValidated(email,password)){
               performLoginPartner(email,password)
           }else{
               emitValidationErrors(email,password)
           }
        }
    }

    fun saveLoginState(state:Boolean){
        viewModelScope.launch {
            datastore.setLoginState(state)
        }
    }



    private fun isValidated(email: String,password: String): Boolean{
        val isEmailValidated = validateEmail(email)
        val isPasswordValidated = validatePassword(password)
        val validationOk  = isEmailValidated is RegisterValidation.Success && isPasswordValidated is RegisterValidation.Success
        return validationOk
    }

    private suspend fun performLoginPartner(email: String,password: String){
        try {
            _isloggedIn.emit(NetworkResult.Loading())

           val firebaseUser =  auth.signInWithEmailAndPassword(email,password).await()

            val user = firebaseUser.user
            if (user!=null){
                _isloggedIn.emit(NetworkResult.Success(user))
                saveLoginState(true)
            }else{
                _isloggedIn.emit(NetworkResult.Error("Unable To Login,Please try later.."))
            }


        }catch (e: Exception){
            _isloggedIn.emit(NetworkResult.Error(e.message))
        }
    }

    private suspend fun emitValidationErrors(email: String,password: String){
        val emailValidation = validateEmail(email)
        val passwordValidation = validatePassword(password)

        val loginState = LoginState(emailValidation,passwordValidation)
        _isValidated.send(loginState)
    }


    fun resetPassword(email: String){
        viewModelScope.launch{
            try {
                _isReseted.emit(NetworkResult.Loading())

                auth.sendPasswordResetEmail(email).await() ?:
                _isReseted.emit(NetworkResult.Error("Password Reset Unsuccessfull"))

                _isReseted.emit(NetworkResult.Success(email))


            }catch (e: Exception){
                _isReseted.emit(NetworkResult.Error(e.message))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        _isValidated.close()
    }


}