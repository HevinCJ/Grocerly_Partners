package com.example.grocerlypartners.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerlypartners.R
import com.example.grocerlypartners.adaptor.AcceptedAdaptor
import com.example.grocerlypartners.databinding.FragmentAcceptedBinding
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OrderStatus
import com.example.grocerlypartners.utils.OrderUiState
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch

class Accepted : Fragment() {
    private var accepted: FragmentAcceptedBinding?=null
    private val binding get() = accepted!!

    private val ordersSharedViewModel: OrdersSharedViewModel by activityViewModels()

    private lateinit var loadingDialogue: LoadingDialogue

    private lateinit var acceptedAdaptor: AcceptedAdaptor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       accepted = FragmentAcceptedBinding.inflate(inflater,container,false)
        loadingDialogue = LoadingDialogue(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRcViewAcceptedOrder()
        observeAcceptedOrder()
        observeOrderStatus()
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

    override fun onResume() {
        super.onResume()
        ordersSharedViewModel.getAcceptedOrders()
    }

    private fun setRcViewAcceptedOrder() {
        acceptedAdaptor = AcceptedAdaptor(
            onAccept = { order ->
                AlertDialog.Builder(requireContext()).apply {
                    setTitle("Ready")
                    setMessage("Are you sure to set order as Ready?")
                    setPositiveButton("Yes") { dialogue, which ->
                        ordersSharedViewModel.setOrderStatus(order, OrderStatus.READY)
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
        binding.rcViewAccepted.apply {
            adapter = acceptedAdaptor
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun observeAcceptedOrder() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.Accepted>().collectLatest {

                if (it.result.data.isNullOrEmpty()){
                    binding.txtviewnopending.visibility = View.VISIBLE
                }else{
                    binding.txtviewnopending.visibility = View.INVISIBLE
                }

                when(it.result){
                    is NetworkResult.Error<*> ->{
                        Toast.makeText(requireContext(), it.result.message, Toast.LENGTH_SHORT).show()
                        loadingDialogue.dismiss()
                    }
                    is NetworkResult.Loading<*> -> {
                        loadingDialogue.show()
                    }
                    is NetworkResult.Success<*> -> {
                        loadingDialogue.dismiss()
                        acceptedAdaptor.submitList(it.result.data)

                    }
                    is NetworkResult.UnSpecified<*> -> {
                        loadingDialogue.dismiss()
                    }
                }
            }
        }
    }


}