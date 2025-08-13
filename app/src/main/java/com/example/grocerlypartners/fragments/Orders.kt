package com.example.grocerlypartners.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.grocerlypartners.adaptor.OrdersPagerAdaptor
import com.example.grocerlypartners.databinding.FragmentOrdersBinding
import com.google.android.material.tabs.TabLayoutMediator

class Orders : Fragment() {
   private  var orders: FragmentOrdersBinding?=null
    private val binding get() = orders!!

    private val ordersPagerAdaptor by lazy { OrdersPagerAdaptor(this) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       orders = FragmentOrdersBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setTabLayoutAndViewPager()
    }

    private fun setTabLayoutAndViewPager() {
        binding.viewpagerstatus.adapter = ordersPagerAdaptor

        TabLayoutMediator(binding.tabLayoutstatus,binding.viewpagerstatus){tab,position->
            tab.text = when(position){
                0 -> "Pending"
                1 -> "Accepted"
                2 -> "Ready"
                3 -> "Shipped"
                else -> null
            }
        }.attach()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        orders = null
    }

}