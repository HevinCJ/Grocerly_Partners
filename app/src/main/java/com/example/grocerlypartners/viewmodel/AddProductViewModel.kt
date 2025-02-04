package com.example.grocerlypartners.viewmodel

import android.app.Application
import android.graphics.Bitmap
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.ProductCategory
import com.example.grocerlypartners.utils.ProductValidation
import com.example.grocerlypartners.utils.productValidationState
import com.example.grocerlypartners.utils.validateProduct
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.File
import java.io.FileOutputStream
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(private val auth: FirebaseAuth,private val db:FirebaseFirestore ,application: Application):AndroidViewModel(application) {

    private val _uploadProduct = MutableSharedFlow<NetworkResult<String>>()
    val uploadProduct:Flow<NetworkResult<String>> get() = _uploadProduct.asSharedFlow()

    private val _productValState = Channel<productValidationState>()
    val productValState:Flow<productValidationState> get() = _productValState.consumeAsFlow()



    fun uploadProductToFirebase(product: Product){
        viewModelScope.launch {
            if (isProductValidated(product)){
                uploadDataToDb(product)
            }else{
                emitProductionValidationErrors(product)
            }
        }
    }

    private suspend fun uploadDataToDb(product: Product) {
        _uploadProduct.emit(NetworkResult.Loading())
       try {

           val userId = auth.currentUser?.uid.toString()

           db.collection(PARTNERS)
               .document(userId)
               .collection(PRODUCTS)
               .add(product)
               .await()

           _uploadProduct.emit(NetworkResult.Success("Added ${product.itemName}"))

       }catch (e:Exception){
           _uploadProduct.emit(NetworkResult.Error(e.message))
       }
    }

    private fun parseProductIntoString(category: ProductCategory):String {
        return when(category){
            ProductCategory.selectcatgory -> "Select a Category"
            ProductCategory.FruitsandVegies -> "Fruits & Vegies"
            ProductCategory.FrozenFoods -> "Frozen Foods"
            ProductCategory.BreadandBakery -> "Bread & Bakery"
            ProductCategory.PersonalCare -> "Personal Care"
            ProductCategory.Households -> "House Holds"
            ProductCategory.HealthCare -> "Health Care"
            ProductCategory.Meat -> "Meat"
        }
    }

    private suspend fun emitProductionValidationErrors(product: Product) {
        val productValState = productValidationState(validateProduct(product))
        _productValState.send(productValState)
    }

    fun parseStringIntoProduct(productCategory: String):ProductCategory{

       return when(productCategory){
           "Fruits & Vegies" -> ProductCategory.FruitsandVegies
           "Frozen Foods" -> ProductCategory.FrozenFoods
           "Bread & Bakery" ->   ProductCategory.BreadandBakery
           "Personal Care" -> ProductCategory.PersonalCare
           "House Holds" -> ProductCategory.Households
           "Health Care" -> ProductCategory.HealthCare
           "Meat" ->ProductCategory.Meat
           else ->{
                 ProductCategory.selectcatgory
           }
       }
    }

    private fun isProductValidated(product: Product): Boolean {
        val isvalidated = validateProduct(product)
        return isvalidated is ProductValidation.success
    }

     fun generateRandomImageName(): String {
         return "IMG_${System.currentTimeMillis()}_${(1000..9999).random()}"
    }




}