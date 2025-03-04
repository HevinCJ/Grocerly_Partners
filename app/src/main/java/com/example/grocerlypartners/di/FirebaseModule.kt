package com.example.grocerlypartners.di

import com.example.grocerlypartners.repository.UpdateProductRepoImpl
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.Constants.PRODUCTS
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideAuth() = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFireStore() = FirebaseFirestore.getInstance()




}