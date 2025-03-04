package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerlypartners.adaptor.OfferAdaptor
import com.example.grocerlypartners.databinding.FragmentOffersBinding
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.viewmodel.AddOfferViewModel
import com.example.grocerlypartners.viewmodel.OfferViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Offers : Fragment() {
    private var offers:FragmentOffersBinding?=null
    private val binding get() = offers!!

    private val offerViewModel by viewModels<OfferViewModel>()

    private val addOfferViewModel by viewModels<AddOfferViewModel>()

    private lateinit var loadingDialogue: LoadingDialogue

    private val offerAdaptor:OfferAdaptor by lazy { OfferAdaptor() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        offerViewModel.getOfferFromFirebase()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        offers = FragmentOffersBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        offerViewModel.getOfferFromFirebase()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadingDialogue = LoadingDialogue(requireContext())
        observeOffersFromFirebase()
        setDeleteOffer()
        observeOfferDeletion()
    }

    private fun observeOfferDeletion() {
        offerViewModel.deletedOffer.observe(viewLifecycleOwner) { result ->
            when (result) {
                is NetworkResult.Error -> {
                    loadingDialogue.dismiss()
                }

                is NetworkResult.Loading -> {
                    loadingDialogue.show()
                }

                is NetworkResult.Success -> {
                    loadingDialogue.dismiss()
                    offerViewModel.getOfferFromFirebase()
                    result.data?.let {
                        showSnackBar(it)
                    }

                }

                is NetworkResult.UnSpecified -> {
                    loadingDialogue.dismiss()
                }
            }
        }
    }

    private fun showSnackBar(data: OfferItem) {
        Snackbar.make(requireView(),"Deleted Offer",Snackbar.LENGTH_LONG).setAction("Undo"){
            addOfferViewModel.insertOfferIntoIntoFirebase(data)
            addOfferViewModel.offerAdded.observe(viewLifecycleOwner) { result ->
                if (result is NetworkResult.Success) {
                    offerViewModel.getOfferFromFirebase()
                    loadingDialogue.dismiss()
                }
            }

        }.show()
    }

    private fun setDeleteOffer() {
        val itemTouchCallback = object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val offer = offerAdaptor.getOffer(position)
                offerViewModel.deleteOfferFromFirebase(offer)
            }

        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(binding.rcviewoffers)
    }

    private fun observeOffersFromFirebase() {
            offerViewModel.offerItems.observe(viewLifecycleOwner){result->
                when(result){
                    is NetworkResult.Error -> {
                        loadingDialogue.dismiss()
                        Toast.makeText(requireContext(),result.message,Toast.LENGTH_SHORT).show()
                    }
                    is NetworkResult.Loading -> {
                        loadingDialogue.show()
                    }
                    is NetworkResult.Success ->{
                        loadingDialogue.dismiss()
                        result.data?.let {
                            setOfferAdaptor(it)
                        }
                    }
                    is NetworkResult.UnSpecified -> {
                        loadingDialogue.dismiss()
                    }
                }
            }

    }

    private fun setOfferAdaptor(it: List<OfferItem>) {
        binding.apply {
            rcviewoffers.adapter = offerAdaptor
            rcviewoffers.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            offerAdaptor.setOffers(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        offers=null
    }


}