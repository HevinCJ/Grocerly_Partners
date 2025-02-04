package com.example.grocerlypartners.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObjects
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val db:FirebaseFirestore, private val auth:FirebaseAuth, application: Application):AndroidViewModel(application) {

    private val _product = MutableStateFlow<NetworkResult<List<Product>>>(NetworkResult.UnSpecified())
    val product:Flow<NetworkResult<List<Product>>> get() = _product.asStateFlow()


    fun fetchProductAddedByPartnerFromFirebase(){
      viewModelScope.launch {

          _product.value = NetworkResult.Loading()

         try {
             val userId = auth.currentUser?.uid.toString()

             val querySnapshot = db.collection(PARTNERS)
                 .document(userId)
                 .collection(PRODUCTS)
                 .get()
                 .await()

             val productList = querySnapshot.toObjects(Product::class.java)
             Log.d("productList",productList.toString())

             _product.value = NetworkResult.Success(productList)

         }catch (e:Exception){
             _product.value = NetworkResult.Error(e.message)
         }
      }
    }

}