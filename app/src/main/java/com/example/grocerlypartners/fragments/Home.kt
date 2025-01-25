package com.example.grocerlypartners.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       home = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionToAddProduct()
        observeProductFetchFromFirebase()
        setRcViewForHomeAdaptor()
    }

    override fun onResume() {
        super.onResume()
        observeProductFetchFromFirebase()
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
                   is NetworkResult.UnSpecified -> TODO()
               }
           }
       }

    }

    private fun actionToAddProduct() {
        binding.apply {
           floatingActionButton2.setOnClickListener {
               findNavController().navigate(R.id.action_home_to_addProduct)
           }
        }
    }


}