package com.example.grocerlypartners.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.repository.SettingsRepoImpl
import com.example.grocerlypartners.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(private val settingsRepoImpl: SettingsRepoImpl):ViewModel() {

    private val _logout = MutableSharedFlow<NetworkResult<String>>()
    val logout:LiveData<NetworkResult<String>> get() = _logout.asLiveData()

    fun logoutFromFirebase(){
        viewModelScope.launch { handleNetworkResultLogout() }
    }

    private suspend fun handleNetworkResultLogout() {
       _logout.emit(NetworkResult.Loading())
        val state = settingsRepoImpl.signOut()
        _logout.emit(state)
    }

}