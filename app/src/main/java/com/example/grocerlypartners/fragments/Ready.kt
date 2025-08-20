package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerlypartners.R
import com.example.grocerlypartners.adaptor.ReadyAdaptor
import com.example.grocerlypartners.databinding.FragmentReadyBinding
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OrderStatus
import com.example.grocerlypartners.utils.OrderUiState
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Ready : Fragment() {
    private var ready: FragmentReadyBinding?=null
    private val binding get() = ready!!

    private val ordersSharedViewModel: OrdersSharedViewModel by activityViewModels ()

    private lateinit var loadingDialogue: LoadingDialogue

    private lateinit var readyAdaptor: ReadyAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        ready = FragmentReadyBinding.inflate(inflater,container,false)
        loadingDialogue = LoadingDialogue(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setReadyAdaptor()
        observeReadyState()
        observeOrderStatus()
        observeCancelledOrders()
    }

    private fun observeCancelledOrders() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.Cancelled>().collectLatest {
                when(it.result){
                    is NetworkResult.Error<*> -> {
                        Toast.makeText(requireContext(), it.result.message, Toast.LENGTH_SHORT).show()
                        loadingDialogue.dismiss()
                    }
                    is NetworkResult.Loading<*> -> {
                        loadingDialogue.show()
                    }
                    is NetworkResult.Success<*> -> {
                        it.result.data?.let {orders ->
                            readyAdaptor.setCancelledItems(orders)
                        }
                        loadingDialogue.dismiss()
                    }
                    is NetworkResult.UnSpecified<*> -> {
                        loadingDialogue.dismiss()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        ordersSharedViewModel.getReadyOrders()
        ordersSharedViewModel.getCancelledOrders()
    }

    private fun observeOrderStatus() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.OrderStatus>().collectLatest {
                if (it.result is NetworkResult.Error){
                    Toast.makeText(requireContext(),it.result.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun setReadyAdaptor() {
        readyAdaptor = ReadyAdaptor(
            onAccept = {
                order -> AlertDialog.Builder(requireContext()).apply {
                setTitle("Shipped")
                setMessage("Are you sure to set order as shipped?")
                setPositiveButton("Yes") { dialogue, which ->
                    ordersSharedViewModel.setOrderStatus(order, OrderStatus.SHIPPED)
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
        binding.rcViewReady.adapter = readyAdaptor
        binding.rcViewReady.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    }

    private fun observeReadyState() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.Ready>().collectLatest {
                when(it.result){
                    is NetworkResult.Error<*> -> {
                        Toast.makeText(requireContext(), it.result.message, Toast.LENGTH_SHORT).show()
                        loadingDialogue.dismiss()
                    }
                    is NetworkResult.Loading<*> -> {
                        loadingDialogue.show()
                    }
                    is NetworkResult.Success<*> ->{
                        loadingDialogue.dismiss()
                        readyAdaptor.submitList(it.result.data)
                        Log.d("readygot",it.result.data.toString())

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