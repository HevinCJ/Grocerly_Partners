package com.example.grocerlypartners.fragments

import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.FragmentAddOfferBinding
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.ColorPickerView
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import com.skydoves.colorpickerview.listeners.ColorListener
import com.skydoves.colorpickerview.listeners.ColorPickerViewListener

class AddOffer : Fragment() {
    private var addoffer:FragmentAddOfferBinding?=null
    private val binding get() = addoffer!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       addoffer = FragmentAddOfferBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showPreviewToUser()
       setColorPickButtonForBackground()
    }

    private fun setColorPickButtonForBackground() {
        binding.colorpickbtn.setOnClickListener {
            ColorPickerDialog.Builder(requireContext())
                .setTitle("Pick a Color")
                .setPreferenceName("ColorPickerDialog")
                .setPositiveButton("Confirm", ColorEnvelopeListener { envelope, _ ->
                    val selectedHexColor = "#${envelope.hexCode}"
                    val focusedEditText = requireActivity().currentFocus  as? EditText

                    if (focusedEditText!=null){
                        focusedEditText.setText(selectedHexColor)
                        focusedEditText.setSelection(selectedHexColor.length)
                    }


                })
                .setNegativeButton("Cancel") { dialog, _ -> dialog.dismiss() }
                .attachAlphaSlideBar(true)
                .attachBrightnessSlideBar(true)
                .show()


        }
    }

    private fun showPreviewToUser() {
        binding.apply {
            reloadbtn.setOnClickListener {
              try {

                  crdviewpreview.setCardBackgroundColor(Color.parseColor(edttxtcardcolor.text.toString()))
                  Glide.with(imgviewItem.context).load(edttxtimageurl.text.toString()).into(imgviewItem)
                  shopnowbtn.text = edttxtbuttonquote.text.toString().trim()
                  shopnowbtn.setTextColor(Color.parseColor(edttxtbuttontxtcolor.text.toString()))
                  shopnowbtn.setBackgroundColor(Color.parseColor(edttxtbuttoncolor.text.toString()))
                  txtviewofferText.text = edttxtdescription.text.toString().trim()
                  txtviewofferText.setTextColor(Color.parseColor(edttxtdescriptioncolor.text.toString()))


              }catch (e:Exception){
                  Toast.makeText(requireContext(),"Invalid Input",Toast.LENGTH_SHORT).show()
              }
            }
        }
    }

}