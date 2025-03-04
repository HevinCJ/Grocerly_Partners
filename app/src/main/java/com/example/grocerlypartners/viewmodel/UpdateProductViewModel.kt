package com.example.grocerlypartners.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.repository.UpdateProductRepoImpl
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.ProductValidation
import com.example.grocerlypartners.utils.productValidationState
import com.example.grocerlypartners.utils.validateProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UpdateProductViewModel @Inject constructor(private val updateProductRepoImpl: UpdateProductRepoImpl):ViewModel() {

    private val _updateProduct = MutableSharedFlow<NetworkResult<String>>()
    val updateProduct:LiveData<NetworkResult<String>> get() = _updateProduct.asLiveData()

    private val _productValidationState = Channel<productValidationState>()
    val productValidationState:Flow<productValidationState> get() = _productValidationState.receiveAsFlow()


    fun updateDataIntoFirebase(product:Product) = viewModelScope.launch {
        updateDataIntoFirebaseSafeCall(product)
    }

    private suspend fun updateDataIntoFirebaseSafeCall(product: Product) {
        if (isProductValidated(product)) {
            val result = updateProductRepoImpl.updateProduct(product)
            Log.d("updatingorNot",result.toString())
            _updateProduct.emit(result)

        }else{
            emitProductValidationErrors(product)
        }
    }

    private suspend fun emitProductValidationErrors(product: Product) {
        val state = productValidationState(validateProduct(product))
        _productValidationState.send(state)
    }


    private fun isProductValidated(product: Product):Boolean {
        val isProductValidated = validateProduct(product)
        return isProductValidated is ProductValidation.success
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        _productValidationState.close()
    }

}