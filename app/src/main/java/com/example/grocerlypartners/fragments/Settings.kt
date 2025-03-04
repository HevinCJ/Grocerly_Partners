package com.example.grocerlypartners.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.grocerlypartners.activity.LoginActivity
import com.example.grocerlypartners.databinding.FragmentSettingsBinding
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.viewmodel.SettingsViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Settings : Fragment() {
   private var settings:FragmentSettingsBinding?=null
    private val binding get() = settings!!

    private lateinit var loadingDialogue: LoadingDialogue

    private val settingsViewModel by viewModels<SettingsViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       settings = FragmentSettingsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpLogout()
        observeLogoutState()
        loadingDialogue = LoadingDialogue(requireContext())
    }

    private fun observeLogoutState() {
        settingsViewModel.logout.observe(viewLifecycleOwner){state->
            when(state){
                is NetworkResult.Error ->{
                    loadingDialogue.dismiss()
                }
                is NetworkResult.Loading -> {
                    loadingDialogue.show()
                }
                is NetworkResult.Success -> {
                    val intent = Intent(requireActivity(),LoginActivity::class.java).apply {
                        putExtra("skip_splash",true)
                    }
                    startActivity(intent)
                    requireActivity().finish()
                }
                is NetworkResult.UnSpecified -> {
                    loadingDialogue.dismiss()
                }
            }
        }
    }

    private fun setUpLogout() {
        binding.apply {
            logoutbtn.setOnClickListener {
             AlertDialog.Builder(requireContext())
                   .setTitle("Log Out")
                   .setMessage("Are You Sure you want To Logout this Session ?")
                   .setPositiveButton("Logout"){_, _ ->
                       settingsViewModel.logoutFromFirebase()
                   }
                   .setNegativeButton("Cancel"){dialog,_ ->
                       dialog.dismiss()
                   }.show()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        settings=null
    }

}