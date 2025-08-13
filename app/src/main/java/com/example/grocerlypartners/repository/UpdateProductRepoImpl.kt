package com.example.grocerlypartners.repository

import android.net.Uri
import android.util.Log
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.example.grocerlypartners.utils.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.util.UUID
import javax.inject.Inject


@ActivityRetainedScoped
class UpdateProductRepoImpl @Inject constructor(private val db:FirebaseFirestore, private val auth: FirebaseAuth,private val storage: FirebaseStorage) {

    private val userId = auth.currentUser?.uid.toString()
    private val updateProductRef =   db.collection(PARTNERS).document(userId).collection(PRODUCTS)

    suspend fun updateProduct(product: Product):NetworkResult<String>{
        return try {

                updateProductRef
                .document(product.productId)
                .update(product.toHashMap())
                .await()


             NetworkResult.Success("Updated ${product.itemName}")

        }catch(e:Exception){
            return NetworkResult.Error(e.message)
        }
    }


    fun uploadImageToFirebase(uri: Uri): Flow<NetworkResult<String>> = callbackFlow {

        if (uri.path.isNullOrEmpty()){
            trySend(NetworkResult.Error("Image path not found\nPlease try again"))
            return@callbackFlow
        }

        if (userId.isEmpty()){
            trySend(NetworkResult.Error("User not found\nPlease login again.."))
            return@callbackFlow
        }

        val storageRef = storage.reference.child("$PARTNERS/$userId/images/${UUID.randomUUID()}.jpg")
        val snapshot = storageRef.putFile(uri).await()
        val imageUrl = snapshot.storage.downloadUrl.await().toString()
        trySend(NetworkResult.Success(imageUrl))

        awaitClose()
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