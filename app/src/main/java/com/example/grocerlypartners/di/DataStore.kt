package com.example.grocerlypartners.di

import android.content.Context
import com.example.grocerlypartners.preferences.GrocerlyDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStore {

    @Provides
    @Singleton
    fun provideDataStore( @ApplicationContext context: Context):GrocerlyDataStore{
        return GrocerlyDataStore(context)
    }

}