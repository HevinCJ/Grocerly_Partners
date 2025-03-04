package com.example.grocerlypartners.repository

import android.util.Log
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.example.grocerlypartners.utils.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.tasks.await
import javax.inject.Inject


@ActivityRetainedScoped
class UpdateProductRepoImpl @Inject constructor(private val db:FirebaseFirestore,
                                                private val auth: FirebaseAuth
) {


    suspend fun updateProduct(product: Product):NetworkResult<String>{
        return try {
            val userId = auth.currentUser?.uid.toString()

            db.collection(PARTNERS)
                .document(userId)
                .collection(PRODUCTS)
                .document(product.productId)
                .update(product.toHashMap())
                .await()


             NetworkResult.Success("Updated ${product.itemName}")

        }catch(e:Exception){
            return NetworkResult.Error(e.message)
        }
    }


    private fun Product.toHashMap():HashMap<String,Any?>{
           return hashMapOf(
               "productId" to productId,
               "image" to image,
               "itemName" to itemName,
               "itemPrice" to itemPrice,
               "category" to category.name,
               "itemRating" to itemRating,
               "totalRating" to totalRating
           )
    }

}