package com.example.grocerlypartners.preferences

import android.content.Context
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import com.google.firebase.firestore.remote.Datastore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

private val Context.datastore by  preferencesDataStore("GROCERLY_PARTNERS")

class GrocerlyDataStore( @ApplicationContext context: Context) {

    private val datastore = context.datastore

    companion object{
        val isLoggedIn = booleanPreferencesKey("IsLogged")
    }

    suspend fun setLoginState(islogin:Boolean){
        datastore.edit {prefs->
            prefs[isLoggedIn] = islogin
        }
    }


    fun getLoginState():Flow<Boolean>{
        return datastore.data
            .catch {exception->
                if (exception is IOException){
                    emit(emptyPreferences())
                }else{
                    throw exception
                }
            }
            .map {prefs->
               val loginState =  prefs[isLoggedIn] ?: false
                 loginState
            }
    }


}