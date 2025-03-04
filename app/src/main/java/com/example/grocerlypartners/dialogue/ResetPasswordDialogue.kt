package com.example.grocerlypartners.dialogue

import android.util.Patterns
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.grocerlypartners.databinding.ResetPasswordLayoutBinding
import com.example.grocerlypartners.viewmodel.SharedViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

fun Fragment.SetUpBottomDialogue(sharedViewModel: SharedViewModel,onSend:(String)-> Unit){

    val bottomDialgue = BottomSheetDialog(requireContext())


    val binding = ResetPasswordLayoutBinding.inflate(layoutInflater)
    bottomDialgue.setContentView(binding.root)
    bottomDialgue.show()
    binding.apply {
        btnsend.setOnClickListener{
           if (sharedViewModel.isNetworkAvailable(requireContext())){
               val email = editTextTextEmailAddress.text.toString().trim()

               if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                   onSend(email)
                   bottomDialgue.dismiss()
               }else{
                   Snackbar.make(binding.view,"Invalid Email", Snackbar.LENGTH_SHORT).show()
               }
           }else{
               Toast.makeText(requireContext(),"Enable wifi/cellular",Toast.LENGTH_SHORT).show()
           }
        }

        btncancel.setOnClickListener{
            bottomDialgue.cancel()
        }
    }

}