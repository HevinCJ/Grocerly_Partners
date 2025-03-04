package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.util.Log
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
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerlypartners.R
import com.example.grocerlypartners.adaptor.HomeAdaptor
import com.example.grocerlypartners.databinding.FragmentHomeBinding
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.viewmodel.AddProductViewModel
import com.example.grocerlypartners.viewmodel.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Home : Fragment() {

    private var home: FragmentHomeBinding?=null
    private val binding get() = home!!

    private val homeViewModel by viewModels<HomeViewModel>()
    private val addProductViewModel by viewModels<AddProductViewModel>()

    private val homeAdaptor by lazy { HomeAdaptor() }

    private lateinit var loadingDialogue: LoadingDialogue

    private val rotateOpen:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_open_anim) }
    private val rotateClose:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.rotate_closed_anim) }
    private val fromBottom:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.from_bottom_anim) }
    private val toBottom:Animation by lazy { AnimationUtils.loadAnimation(requireContext(),R.anim.to_bottom_anim) }
    private var isVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel.fetchProductAddedByPartnerFromFirebase()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       home = FragmentHomeBinding.inflate(inflater,container,false)
        loadingDialogue = LoadingDialogue(requireContext())
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        homeViewModel.fetchProductAddedByPartnerFromFirebase()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionToAddProductAndShowOffers()
        observeProductFetchFromFirebase()
        setRcViewForHomeAdaptor()
        observeDeletedProduct()
    }

    private fun setRcViewForHomeAdaptor() {
        binding.rcviewproducts.apply {
            adapter = homeAdaptor
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun observeDeletedProduct() {
        homeViewModel.deleteProduct.observe(viewLifecycleOwner){result->
            when(result){
                is NetworkResult.Error -> {
                    loadingDialogue.dismiss()
                    Toast.makeText(requireContext(), "Failed to delete", Toast.LENGTH_SHORT).show()
                }
                is NetworkResult.Loading -> {
                    loadingDialogue.show()
                }
                is NetworkResult.Success ->{
                    loadingDialogue.dismiss()
                    result.data?.let {
                        homeViewModel.fetchProductAddedByPartnerFromFirebase()
                        showSnackBar(it)
                    }
                }
                is NetworkResult.UnSpecified -> {
                    loadingDialogue.dismiss()
                }
            }
        }
    }

    private fun showSnackBar(product: Product) {
        Snackbar.make(requireView(),"Deleted ${product.itemName}",Snackbar.LENGTH_SHORT)
            .setAction("Undo"){
                addProductViewModel.uploadProductToFirebase(product)
                addProductViewModel.uploadProduct.observe(viewLifecycleOwner){
                    if (it is NetworkResult.Success){
                        homeViewModel.fetchProductAddedByPartnerFromFirebase()
                        loadingDialogue.dismiss()
                    }
                }

            }.show()
    }

    private fun setSwipeToDelete(recyclerView: RecyclerView) {

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val offer = homeAdaptor.getProduct(position)
                homeViewModel.deleteProduct(offer)
            }


        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun observeProductFetchFromFirebase() {
           homeViewModel.product.observe(viewLifecycleOwner){result->
               when(result){
                   is NetworkResult.Error -> {
                       Toast.makeText(requireContext(),result.message, Toast.LENGTH_SHORT).show()
                       loadingDialogue.dismiss()

                   }
                   is NetworkResult.Loading ->{
                      loadingDialogue.show()

                   }
                   is NetworkResult.Success -> {
                       result.data?.let {
                           homeAdaptor.setProduct(it )
                           setSwipeToDelete(binding.rcviewproducts)
                       }
                       loadingDialogue.dismiss()

                   }
                   is NetworkResult.UnSpecified -> {
                       loadingDialogue.dismiss()
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
               findNavController().navigate(R.id.action_products_to_addProduct)
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