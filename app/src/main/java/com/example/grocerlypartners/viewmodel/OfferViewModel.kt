package com.example.grocerlypartners.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.repository.OfferRepoImpl
import com.example.grocerlypartners.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.cancel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OfferViewModel @Inject constructor(private val offerRepoImpl: OfferRepoImpl):ViewModel() {

    private val _deletedOffer = MutableSharedFlow<NetworkResult<OfferItem>>()
    val deletedOffer:LiveData<NetworkResult<OfferItem>> get() = _deletedOffer.asLiveData()

    private val _offerItems = MutableStateFlow<NetworkResult<List<OfferItem>>>(NetworkResult.UnSpecified())
    val offerItems:LiveData<NetworkResult<List<OfferItem>>> get() = _offerItems.asLiveData()

    fun getOfferFromFirebase(){
        viewModelScope.launch {
            fetchOfferFromDb()
        }
    }


    fun deleteOfferFromFirebase(offerItem: OfferItem){
        viewModelScope.launch {
            handleNetworkResultForDeleteOffer(offerItem)
        }
    }

    private suspend fun handleNetworkResultForDeleteOffer(offerItem: OfferItem) {
        _deletedOffer.emit(NetworkResult.Loading())
        val deletedOffer = offerRepoImpl.deleteOfferFromFirebase(offerItem)
        _deletedOffer.emit(deletedOffer)
    }

    private suspend fun fetchOfferFromDb() {
        _offerItems.value = NetworkResult.Loading()

       offerRepoImpl.retreiveOfferFromFirebase().data?.let {
           _offerItems.value = NetworkResult.Success(it)
       }

        offerRepoImpl.retreiveOfferFromFirebase().message?.let {
            _offerItems.value = NetworkResult.Error(it)
        }

    }




    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }


}