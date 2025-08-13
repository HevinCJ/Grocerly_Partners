package com.example.grocerlypartners.application

import android.app.Application
import androidx.compose.ui.text.font.FontStyle
import com.example.grocerlypartners.R
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GrocerlyPartnersApp(): Application(){
    override fun onCreate() {
        super.onCreate()
        FirebaseFirestore.getInstance().clearPersistence()
    }
}
