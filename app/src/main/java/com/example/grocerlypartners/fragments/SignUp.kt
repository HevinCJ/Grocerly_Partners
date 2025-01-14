package com.example.grocerlypartners.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.FragmentSignUpBinding
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.RegisterValidation
import com.example.grocerlypartners.viewmodel.SignUpViewModel
import com.google.android.material.animation.AnimationUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUp : Fragment() {
   private var signup: FragmentSignUpBinding?= null
    private val binding get() = signup!!

    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       signup = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actionToLoginUi()
        observeSignUp()
        observeSignUpUiState()
        performSignUp()
    }

    private fun performSignUp() {
        binding.apply {
          signupbtn.setOnClickListener{
              val name = edttxtname.text.toString().trim()
              val email = edttxtemail.text.toString().trim()
              val password = edttxtpassword.text.toString().trim()
              signUpViewModel.performSignUpForPartner(name,email,password)
          }
        }
    }

    private fun observeSignUp() {
     lifecycleScope.launch{
         signUpViewModel.isSigned.collect{result->
             when(result){
                 is NetworkResult.Error -> {
                     Toast.makeText(requireContext(),result.message, Toast.LENGTH_SHORT).show()
                 }
                 is NetworkResult.Loading -> {
                     Toast.makeText(requireContext(),"Loading,Please wait..", Toast.LENGTH_SHORT).show()

                 }
                 is NetworkResult.Success -> {
                     findNavController().navigate(R.id.action_signUp_to_login)
                     Toast.makeText(requireContext(),"Signed In as ${result.data?.email}", Toast.LENGTH_SHORT).show()
                 }
                 is NetworkResult.UnSpecified -> TODO()
             }
         }
     }
    }

    private fun actionToLoginUi() {
        binding.apply {
            actiontosignuptxtview.setOnClickListener{
                findNavController().navigate(R.id.action_signUp_to_login)
            }
        }
    }

    private fun observeSignUpUiState(){
        lifecycleScope.launch{
            signUpViewModel.signUpState.collect{state->
                if (state.name is RegisterValidation.Failure){
                    binding.edttxtname.apply {
                        requestFocus()
                        error = state.name.message
                    }
                }

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



}