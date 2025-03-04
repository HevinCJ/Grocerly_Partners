package com.example.grocerlypartners.repository

import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.example.grocerlypartners.utils.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AddProductRepoImpl @Inject constructor(private val db:FirebaseFirestore,private val auth:FirebaseAuth) {


     suspend fun uploadDataToDb(product: Product):NetworkResult<String> {
         return try {

            val userId = auth.currentUser?.uid.toString()

            db.collection(PARTNERS)
                .document(userId)
                .collection(PRODUCTS)
                .document(product.productId)
                .set(product)
                .await()

            NetworkResult.Success("Added ${product.itemName}")

        }catch (e:Exception){

           NetworkResult.Error(e.message)
        }
    }

}