package com.example.grocerlypartners.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.grocerlypartners.R
import com.example.grocerlypartners.activity.MainActivity
import com.example.grocerlypartners.databinding.FragmentSplashBinding
import com.example.grocerlypartners.viewmodel.LoginViewModel

class Splash : Fragment() {
    private var splash:FragmentSplashBinding?=null
    private val binding get() = splash!!

    private lateinit var loginViewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(requireActivity())[LoginViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        splash = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        },3000)
    }

    private fun navigateToHome() {
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.splash,true).build()

        loginViewModel.loginState.observe(viewLifecycleOwner){
            when(it){
                true ->{
                    val intent = Intent(requireActivity(),MainActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                false ->{
                    findNavController().navigate(R.id.action_splash_to_login,null,navOptions)
                }
            }
        }
    }

}