package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerlypartners.R
import com.example.grocerlypartners.adaptor.PendingAdaptor
import com.example.grocerlypartners.databinding.FragmentAcceptedBinding
import com.example.grocerlypartners.databinding.FragmentPendingBinding
import com.example.grocerlypartners.databinding.ReasonSpinnerBinding
import com.example.grocerlypartners.model.CancellationInfo
import com.example.grocerlypartners.model.Order
import com.example.grocerlypartners.utils.CancellationStatus
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OrderStatus
import com.example.grocerlypartners.utils.OrderUiState
import com.example.grocerlypartners.utils.Reason
import com.example.grocerlypartners.viewmodel.OrdersSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Pending : Fragment() {
    private var pending: FragmentPendingBinding? = null
    private val binding get() = pending!!

    private val ordersSharedViewModel: OrdersSharedViewModel by viewModels()

    private lateinit var pendingAdaptor: PendingAdaptor

    private lateinit var loadingDialogue: LoadingDialogue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        pending = FragmentPendingBinding.inflate(inflater, container, false)
        loadingDialogue = LoadingDialogue(requireContext())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRcView()
        observePendingOrders()
        observeUpdatedStateStatus()
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

    private fun observeUpdatedStateStatus() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.OrderStatus>().collectLatest {
                if (it.result is NetworkResult.Error){
                    Toast.makeText(requireContext(), it.result.message, Toast.LENGTH_SHORT).show()
                    Log.d("errorgot",it.result.message.toString())
                }
            }

        }
    }

    override fun onResume() {
        super.onResume()
        ordersSharedViewModel.getPendingOrders()
        ordersSharedViewModel.cleanCancelledOrders()
    }

    private fun setRcView() {
       pendingAdaptor =  PendingAdaptor(
            onAccept = {
                order ->
                AlertDialog.Builder(requireContext()).apply {
                    setTitle("Accept Order")
                    setMessage("Are you sure to accept order?")
                    setPositiveButton("Accept Order") { dialogue, which ->
                        ordersSharedViewModel.setOrderStatus(order, OrderStatus.ACCEPTED)
                        dialogue.cancel()
                    }
                    setNegativeButton("Cancel") { dialogue, which ->
                        dialogue.cancel()
                    }
                }.show()
            },
            onCancel = {order ->
                AlertDialog.Builder(requireContext()).apply {
                    setTitle("Cancel Order")
                    setMessage("Are you sure to Cancel order?")
                    setPositiveButton("Cancel Order") { dialogue, which ->

                        val spinnerBinding = ReasonSpinnerBinding.inflate(layoutInflater)
                        val reasons = Reason.entries.map { it.reason }

                        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_spinner_item,reasons)
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                        spinnerBinding.spinnerreason.adapter = adapter

                        val reasonDialogue = AlertDialog.Builder(requireContext())
                            .setView(spinnerBinding.root)
                            .create()
                        spinnerBinding.dismissbtn.setOnClickListener {
                            reasonDialogue.dismiss()
                        }

                        spinnerBinding.canceorderbtn.setOnClickListener {
                            val reason = spinnerBinding.spinnerreason.selectedItem.toString()

                            ordersSharedViewModel.setCancellationStatus(order,reason)
                            reasonDialogue.dismiss()
                        }

                        reasonDialogue.show()

                        dialogue.cancel()
                    }
                    setNegativeButton("Cancel") { dialogue, which ->
                        dialogue.cancel()
                    }
                }.show()
            }
        )

        binding.rcviewpending.apply {
            adapter = pendingAdaptor
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        }
    }

    private fun observePendingOrders() {
        viewLifecycleOwner.lifecycleScope.launch {
            ordersSharedViewModel.orders.filterIsInstance<OrderUiState.Pending>().collectLatest { state->
                when(state.result){
                    is NetworkResult.Error<*> -> {
                        loadingDialogue.dismiss()
                        Toast.makeText(requireContext(), state.result.message, Toast.LENGTH_SHORT).show()
                    }
                    is NetworkResult.Loading<*> ->{
                        loadingDialogue.show()
                    }
                    is NetworkResult.Success<*> -> {
                        loadingDialogue.dismiss()
                        pendingAdaptor.submitList(state.result.data)
                        Log.d("pendingdata",state.result.data.toString())
                        if (state.result.data.isNullOrEmpty()){
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

    override fun onDestroyView() {
        super.onDestroyView()
        pending=null
    }
}

