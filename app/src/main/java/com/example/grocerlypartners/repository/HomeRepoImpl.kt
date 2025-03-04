package com.example.grocerlypartners.repository

import android.util.Log
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.example.grocerlypartners.utils.NetworkResult
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(private val db:FirebaseFirestore,private val auth:FirebaseAuth) {

    suspend fun fetchDataFromFirebaseToHome():NetworkResult<List<Product>>{

        return try {
            val userId = auth.currentUser?.uid.toString()

            val querySnapshot = db.collection(PARTNERS)
                .document(userId)
                .collection(PRODUCTS)
                .get()
                .await()

            val productList = querySnapshot.toObjects(Product::class.java)
            Log.d("productList",productList.toString())

            NetworkResult.Success(productList)

        }catch (e:Exception){
           NetworkResult.Error(e.message)
        }
    }



    suspend fun deleteDataFromFirebase(product: Product):NetworkResult<Product>{
        return try {

            val userId = auth.currentUser?.uid.toString()

            db.collection(PARTNERS)
                .document(userId)
                .collection(PRODUCTS)
                .document(product.productId)
                .delete()
                .await()


            NetworkResult.Success(product)

        }catch (e:Exception){

            NetworkResult.Error(e.message)
        }

    }


}