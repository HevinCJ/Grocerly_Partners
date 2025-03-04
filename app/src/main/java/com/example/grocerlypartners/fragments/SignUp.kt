package com.example.grocerlypartners.fragments

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
import com.example.grocerlypartners.databinding.FragmentSignUpBinding
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.RegisterValidation
import com.example.grocerlypartners.viewmodel.SharedViewModel
import com.example.grocerlypartners.viewmodel.SignUpViewModel
import com.google.android.material.animation.AnimationUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignUp : Fragment() {
   private var signup: FragmentSignUpBinding?= null
    private val binding get() = signup!!

    private val signUpViewModel: SignUpViewModel by viewModels()

    private val sharedViewModel:SharedViewModel by activityViewModels()

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
             if (sharedViewModel.isNetworkAvailable(requireContext())){
                 val firstName = edttxtname.text.toString().trim()
                 val lastName = edttxtlastname.text.toString().trim()
                 val email = edttxtemail.text.toString().trim()
                 val password = edttxtpassword.text.toString().trim()
                 signUpViewModel.performSignUpForPartner(firstName,lastName,email,password)
             }else{
                 Toast.makeText(requireContext(),"Enable wifi/cellular",Toast.LENGTH_SHORT).show()
             }
          }
        }
    }

    private fun observeSignUp() {
     lifecycleScope.launch{
         signUpViewModel.isSigned.collect{result->
             when(result){
                 is NetworkResult.Error -> {
                     Toast.makeText(requireContext(),result.message, Toast.LENGTH_SHORT).show()
                     binding.apply {
                         progressbarsignin.visibility = View.INVISIBLE
                         signupbtn.visibility = View.VISIBLE
                     }
                 }
                 is NetworkResult.Loading -> {
                     binding.apply {
                         progressbarsignin.visibility = View.VISIBLE
                         signupbtn.visibility = View.INVISIBLE
                     }
                 }
                 is NetworkResult.Success -> {
                     findNavController().navigate(R.id.action_signUp_to_login)
                     Toast.makeText(requireContext(),"Signed In as ${result.data?.email}", Toast.LENGTH_SHORT).show()
                     binding.apply {
                         progressbarsignin.visibility = View.INVISIBLE
                         signupbtn.visibility = View.VISIBLE
                     }
                 }
                 is NetworkResult.UnSpecified -> {
                     binding.apply {
                         progressbarsignin.visibility = View.INVISIBLE
                         signupbtn.visibility = View.VISIBLE
                     }
                 }
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
                if (state.firstName is RegisterValidation.Failure){
                    binding.txtinputlayoutfirstname.apply {
                        requestFocus()
                        helperText = state.firstName.message
                    }
                }else{
                    binding.txtinputlayoutfirstname.helperText=null
                }

                if (state.lastName is RegisterValidation.Failure){
                    binding.txtinputlayoutlastname.apply {
                        requestFocus()
                        helperText = state.lastName.message
                    }
                }else{
                    binding.txtinputlayoutlastname.helperText=null
                }

                if (state.email is RegisterValidation.Failure){
                    binding.txtinputlayoutemail.apply {
                        requestFocus()
                        helperText = state.email.message
                    }
                }else{
                    binding.txtinputlayoutemail.helperText=null
                }

                if (state.password is RegisterValidation.Failure){
                    binding.txtinputlayoutpassword.apply {
                        requestFocus()
                        helperText = state.password.message
                    }
                }else{
                    binding.txtinputlayoutpassword.helperText=null
                }

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        signup=null
    }

}