package com.example.grocerlypartners.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerlypartners.R
import com.example.grocerlypartners.adaptor.ShippedAdaptor
import com.example.grocerlypartners.databinding.FragmentShippedBinding
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OrderStatus
import com.example.grocerlypartners.model.OrderUiState
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Shipped : Fragment() {
    private var shipped: FragmentShippedBinding?=null
    private val binding get() = shipped!!

    private lateinit var shippedAdaptor: ShippedAdaptor

    private val ordersSharedViewModel: OrdersSharedViewModel by activityViewModels()

    private lateinit var loadingDialogue: LoadingDialogue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shipped = FragmentShippedBinding.inflate(inflater,container,false)
        loadingDialogue = LoadingDialogue(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRcShippedAdaptor()
        observeShippedOrders()
        observeOrderStatus()
        observeCancelledOrders()
    }



    private fun observeCancelledOrders() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.Cancelled>().collectLatest {
                loadingDialogue.dismiss()
                if(it.result is NetworkResult.Success){
                    it.result.data?.let {orders ->
                        shippedAdaptor.setCancelledItems(orders)
                    }

                    if (it.result is NetworkResult.Error){
                        Toast.makeText(requireContext(), it.result.message.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun observeOrderStatus() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.OrderStatus>().collectLatest {
                if (it.result is NetworkResult.Error){
                    loadingDialogue.dismiss()
                    Toast.makeText(requireContext(),it.result.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onResume() {
        super.onResume()
        ordersSharedViewModel.getShippedOrders()
        ordersSharedViewModel.getCancelledOrders()
    }

    private fun setRcShippedAdaptor() {
        shippedAdaptor = ShippedAdaptor(
            onAccept = {
                    order -> AlertDialog.Builder(requireContext()).apply {
                setTitle("Out for delivery")
                setMessage("Are you sure to set order as Out for Delivery?")
                setPositiveButton("Yes") { dialogue, which ->
                    ordersSharedViewModel.setOrderStatus(order, OrderStatus.OUTFORDELIVERY)
                    dialogue.cancel()
                }
                setNegativeButton("Cancel") { dialogue, which ->
                    dialogue.cancel()
                }
            }.show()
            },
            onDelete = {order ->
                ordersSharedViewModel.deleteOrder(order)
            }
        )
        binding.rcViewShipped.adapter = shippedAdaptor
        binding.rcViewShipped.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    }

    private fun observeShippedOrders() {
       viewLifecycleOwner.lifecycleScope.launch {
           ordersSharedViewModel.orders.filterIsInstance<OrderUiState.Shipped>().collectLatest {
               when(it.result){
                   is NetworkResult.Error<*> -> {
                       loadingDialogue.dismiss()
                   }
                   is NetworkResult.Loading<*> -> {
                       loadingDialogue.show()
                   }
                   is NetworkResult.Success<*> -> {
                       loadingDialogue.dismiss()
                       shippedAdaptor.submitList(it.result.data)

                       if (it.result.data.isNullOrEmpty()){
                           binding.txtviewnopending.visibility = View.VISIBLE
                       }else{
                           binding.txtviewnopending.visibility = View.INVISIBLE
                       }
                   }
                   is NetworkResult.UnSpecified<*> -> {
                       loadingDialogue.dismiss()
                   }
               }
           }
       }
    }


}