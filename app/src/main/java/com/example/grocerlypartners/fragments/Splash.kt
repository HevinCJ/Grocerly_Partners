package com.example.grocerlypartners.fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.grocerlypartners.R
import com.example.grocerlypartners.activity.MainActivity
import com.example.grocerlypartners.databinding.FragmentSplashBinding
import com.example.grocerlypartners.preferences.GrocerlyDataStore
import com.example.grocerlypartners.viewmodel.GraphViewModel
import com.example.grocerlypartners.viewmodel.HomeViewModel
import com.example.grocerlypartners.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Splash : Fragment() {
    private var splash:FragmentSplashBinding?=null
    private val binding get() = splash!!

    @Inject
    lateinit var grocerlyDataStore: GrocerlyDataStore

    private val  homeViewModel: HomeViewModel by viewModels()

    private val graphViewModel: GraphViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        splash = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState!=null) return

        val isLoggedOut = requireActivity().intent.getBooleanExtra("skip_splash",false)

        viewLifecycleOwner.lifecycleScope.launch {
            if (!isLoggedOut) delay(3000)
            navigateToHome()
        }

    }

    private fun navigateToHome() {
       viewLifecycleOwner.lifecycleScope.launch {
          grocerlyDataStore.getLoginState().collectLatest { it ->
              when(it){
                  true -> {
                      findNavController().navigate(R.id.action_splash_to_grocerly_partners_mainnav)
                  }
                  false ->{
                      findNavController().navigate(R.id.action_splash_to_grocerly_partners_authnav)
                  }
              }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        splash=null
    }

}