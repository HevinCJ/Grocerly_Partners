package com.example.grocerlypartners.application

import android.app.Application
import android.os.Build
import androidx.compose.ui.text.font.FontStyle
import com.example.grocerlypartners.R
import com.google.firebase.firestore.BuildConfig
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class GrocerlyPartnersApp(): Application(){
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        FirebaseFirestore.getInstance().clearPersistence()
    }
}
