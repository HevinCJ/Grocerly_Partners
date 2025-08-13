package com.example.grocerlypartners.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.repository.HomeRepoImpl
import com.example.grocerlypartners.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val homeRepoImpl: HomeRepoImpl, application: Application):AndroidViewModel(application) {

    private val _product = MutableStateFlow<NetworkResult<List<Product>>>(NetworkResult.UnSpecified())
    val product:LiveData<NetworkResult<List<Product>>> get() = _product.asLiveData()

    private val _deleteProduct = MutableSharedFlow<NetworkResult<Product>>()
    val deleteProduct:LiveData<NetworkResult<Product>> get() = _deleteProduct.asLiveData()

    val isReady = !_product.value.data.isNullOrEmpty()

    init {
        fetchProductAddedByPartnerFromFirebase()
    }


    fun fetchProductAddedByPartnerFromFirebase(){
      viewModelScope.launch {
         fetchProductFromFirebase()
      }
    }

    private suspend fun fetchProductFromFirebase() {
        _product.emit(NetworkResult.Loading())

        homeRepoImpl.fetchDataFromFirebaseToHome().data?.let {
            _product.emit(NetworkResult.Success(it))
        }

        homeRepoImpl.fetchDataFromFirebaseToHome().message?.let {
            _product.emit(NetworkResult.Error(it))
        }

    }

    fun deleteProduct(offer: Product) {
        viewModelScope.launch {
            deleteProductFromFirebase(offer)
        }
    }

    private suspend fun deleteProductFromFirebase(product: Product) {
        _deleteProduct.emit(NetworkResult.Loading())
        val deleteProduct = homeRepoImpl.deleteDataFromFirebase(product)
        _deleteProduct.emit(deleteProduct)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

}