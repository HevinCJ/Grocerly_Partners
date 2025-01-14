package com.example.grocerlypartners.dialogue

import android.util.Patterns
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.grocerlypartners.databinding.ResetPasswordLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar

fun Fragment.SetUpBottomDialogue(onSend:(String)-> Unit){

    val bottomDialgue = BottomSheetDialog(requireContext())
    bottomDialgue.behavior.state = BottomSheetBehavior.STATE_EXPANDED

    val binding = ResetPasswordLayoutBinding.inflate(layoutInflater)
    bottomDialgue.setContentView(binding.root)
    bottomDialgue.show()

    binding.apply {
        btnsend.setOnClickListener{
            val email = editTextTextEmailAddress.text.toString().trim()

            if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                onSend(email)
                bottomDialgue.dismiss()
            }else{
                Snackbar.make(requireView(),"Invalid Email", Snackbar.LENGTH_SHORT).show()
            }
        }

        btncancel.setOnClickListener{
            bottomDialgue.cancel()
        }
    }

}