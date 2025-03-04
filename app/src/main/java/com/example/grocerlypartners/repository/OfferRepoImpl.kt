package com.example.grocerlypartners.repository

import android.util.Log
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.utils.Constants.OFFERS
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class OfferRepoImpl @Inject constructor(private val db:FirebaseFirestore,private val auth:FirebaseAuth) {

    suspend fun retreiveOfferFromFirebase():NetworkResult<List<OfferItem>>{
        return try {

            val userId  = auth.currentUser?.uid.toString()

            val offerSnapshot = db.collection(PARTNERS)
                .document(userId)
                .collection(OFFERS)
                .get()
                .await()

            val offerList = offerSnapshot.toObjects(OfferItem::class.java)
            Log.d("offerlist",offerList.toString())

            NetworkResult.Success(offerList)
        }catch (e:Exception){

            NetworkResult.Error(e.message)

        }
    }

    suspend fun deleteOfferFromFirebase(offerItem: OfferItem):NetworkResult<OfferItem>{
        return try {
            val userId  = auth.currentUser?.uid.toString()

            db.collection(PARTNERS)
                .document(userId)
                .collection(OFFERS)
                .document(offerItem.offerId)
                .delete()
                .await()

            NetworkResult.Success(offerItem)


        }catch (e:Exception){
            NetworkResult.Error(e.message)
        }
    }

}