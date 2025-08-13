package com.example.grocerlypartners.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.R
import com.example.grocerlypartners.preferences.GrocerlyDataStore
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GraphViewModel @Inject constructor(private val auth: FirebaseAuth, private val grocerlyDataStore: GrocerlyDataStore): ViewModel() {

    private val _targetGraph = MutableStateFlow<Int?>(null)
    val targetGraph get() = _targetGraph.asStateFlow()

    fun decideGraph(){
        viewModelScope.launch {
            val isLoggedIn = grocerlyDataStore.getLoginState().first()
            val currentUser = auth.currentUser?.uid.orEmpty()

            _targetGraph.value = if (currentUser.isNotEmpty() && isLoggedIn){
                R.navigation.grocerly_partners_mainnav
            }else{
                R.navigation.grocerly_partners_authnav
            }
        }
    }

}