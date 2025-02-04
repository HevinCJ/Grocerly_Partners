package com.example.grocerlypartners.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerlypartners.R
import com.example.grocerlypartners.adaptor.HomeAdaptor
import com.example.grocerlypartners.databinding.FragmentHomeBinding
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : Fragment() {

    private var home: FragmentHomeBinding?=null
    private val binding get() = home!!

    private val homeViewModel by viewModels<HomeViewModel>()
    private val homeAdaptor by lazy { HomeAdaptor() }

    private val rotateOpen:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_open_anim) }
    private val rotateClose:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_closed_anim) }
    private val fromBottom:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.from_bottom_anim) }
    private val toBottom:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.to_bottom_anim) }
    private var isVisible = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       home = FragmentHomeBinding.inflate(inflater,container,false)
        homeViewModel.fetchProductAddedByPartnerFromFirebase()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionToAddProductAndShowOffers()
        observeProductFetchFromFirebase()
        setRcViewForHomeAdaptor()
    }

    private fun setRcViewForHomeAdaptor() {
        binding.rcviewproducts.apply {
            adapter = homeAdaptor
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun observeProductFetchFromFirebase() {
       lifecycleScope.launch {
           homeViewModel.product.collect{result->
               when(result){
                   is NetworkResult.Error -> {
                       Toast.makeText(requireContext(),result.message, Toast.LENGTH_SHORT).show()
                   }
                   is NetworkResult.Loading ->{
                       Toast.makeText(requireContext(),"Loading,Please wait..", Toast.LENGTH_SHORT).show()
                   }
                   is NetworkResult.Success -> {
                       result.data?.let {
                           homeAdaptor.setProduct(it)
                       }
                   }
                   is NetworkResult.UnSpecified -> {

                   }
               }
           }
       }

    }

    private fun setVisibility(isenabled: Boolean) {
        binding.apply {
            if (isenabled) {

                offerbtn.visibility = View.VISIBLE
                addProduct.visibility = View.VISIBLE

            } else {
                offerbtn.visibility = View.INVISIBLE
                addProduct.visibility = View.INVISIBLE
            }
        }
    }

    private fun actionToAddProductAndShowOffers() {
        binding.apply {
           floatingActionButton2.setOnClickListener {

               isVisible = !isVisible
               setVisibility(isVisible)
               setAnimation(isVisible)
           }
        }
    }

    private fun setAnimation(isEnabled: Boolean) {
       binding.apply {
           if (isEnabled){
               addProduct.startAnimation(fromBottom)
               offerbtn.startAnimation(fromBottom)
               floatingActionButton2.startAnimation(rotateOpen)
           }else{
               addProduct.startAnimation(toBottom)
               offerbtn.startAnimation(toBottom)
               floatingActionButton2.startAnimation(rotateClose)
           }
           addProduct.setOnClickListener {
               findNavController().navigate(R.id.action_home_to_addProduct)
           }

           offerbtn.setOnClickListener {
               findNavController().navigate(R.id.action_home_to_addOffer)
           }
       }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        home = null
    }


}