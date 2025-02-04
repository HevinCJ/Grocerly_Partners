package com.example.grocerlypartners.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.FragmentUpdateProductBinding

class UpdateProduct : Fragment() {
    private var updateproduct:FragmentUpdateProductBinding?=null
    private val binding get() = updateproduct!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       updateproduct = FragmentUpdateProductBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}