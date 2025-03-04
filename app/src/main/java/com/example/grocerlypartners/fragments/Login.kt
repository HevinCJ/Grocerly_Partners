package com.example.grocerlypartners.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.grocerlypartners.R
import com.example.grocerlypartners.activity.MainActivity
import com.example.grocerlypartners.databinding.FragmentLoginBinding
import com.example.grocerlypartners.dialogue.SetUpBottomDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.RegisterValidation
import com.example.grocerlypartners.viewmodel.LoginViewModel
import com.example.grocerlypartners.viewmodel.SharedViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Login : Fragment() {
    private var login: FragmentLoginBinding?=null
    private val binding get() = login!!

    private val loginViewModel: LoginViewModel by viewModels()

    private val sharedViewModel by activityViewModels<SharedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        login = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginPartnerToDb()
        observeLoginState()
        observeValidationState()
        actionToSignUp()
        resetPasswordForPartner()
        observeResetState()
    }

    private fun observeResetState() {
       lifecycleScope.launch{
           loginViewModel.isReseted.collect{result->
               when(result){
                   is NetworkResult.Error -> {
                       Snackbar.make(requireView(),result.message.toString(), Snackbar.LENGTH_SHORT).show()

                   }
                   is NetworkResult.Loading -> {

                   }
                   is NetworkResult.Success -> {
                       Snackbar.make(requireView(),"Reset Link Sent to ${result.data}", Snackbar.LENGTH_SHORT).show()

                   }
                   is NetworkResult.UnSpecified -> {

                   }
               }
           }
       }
    }

    private fun resetPasswordForPartner() {
        binding.apply {
            forgotpasswordtxtview.setOnClickListener{
                SetUpBottomDialogue(sharedViewModel){email->
                    loginViewModel.resetPassword(email)
                }
            }
        }
    }

    private fun actionToSignUp() {
        binding.apply {
            actiontosignuptxtview.setOnClickListener{
                findNavController().navigate(R.id.action_login_to_signUp)
            }
        }
    }

    private fun loginPartnerToDb() {
        binding.apply {
           loginbtn.setOnClickListener{
               if (sharedViewModel.isNetworkAvailable(requireContext())){
                   val email = edttxtemail.text.toString().trim()
                   val password = edttxtpassword.text.toString().trim()
                   loginViewModel.loginPartnerToFirebase(email,password)
               }else{
                   Toast.makeText(requireContext(),"Enable wifi/cellular",Toast.LENGTH_SHORT).show()
               }

           }
        }
    }


    private fun observeLoginState(){
       lifecycleScope.launch{
           loginViewModel.isloggedIn.collect{result->
               when(result){
                   is NetworkResult.Error -> {
                       Toast.makeText(requireContext(),result.message,Toast.LENGTH_SHORT).show()
                   }
                   is NetworkResult.Loading -> {
                       Toast.makeText(requireContext(),"Loading,Please wait...",Toast.LENGTH_SHORT).show()
                   }
                   is NetworkResult.Success -> {
                      val intent = Intent(requireContext(), MainActivity::class.java)
                       startActivity(intent)
                       requireActivity().finish()
                   }
                   is NetworkResult.UnSpecified -> {

                   }
               }
           }
       }
    }


    private fun observeValidationState(){
        lifecycleScope.launch{
            loginViewModel.isValidated.collect{state->
                if (state.email is RegisterValidation.Failure){
                    binding.edttxtemail.apply {
                       requestFocus()
                        error = state.email.message
                    }
                }

                if (state.password is RegisterValidation.Failure){
                    binding.edttxtpassword.apply {
                        requestFocus()
                        error = state.password.message
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        login=null
    }

}