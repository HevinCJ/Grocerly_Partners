package com.example.grocerlypartners.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.grocerlypartners.R
import com.example.grocerlypartners.activity.MainActivity
import com.example.grocerlypartners.databinding.FragmentAddOfferBinding
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OfferValidation
import com.example.grocerlypartners.viewmodel.AddOfferViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class AddOffer : Fragment() {
    private var addoffer:FragmentAddOfferBinding?=null
    private val binding get() = addoffer!!

    @Inject
    lateinit var db:FirebaseFirestore

    private val addOfferViewModel:AddOfferViewModel by viewModels()

    private lateinit var  loadingDialogue:LoadingDialogue

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
        uploadOfferToFirebase()
        observeOfferValidationState()
        observeAddedOffersInFirebase()
        loadingDialogue= LoadingDialogue(requireContext())
    }

    private fun observeAddedOffersInFirebase() {
        lifecycleScope.launch {
            addOfferViewModel.offerAdded.observe(viewLifecycleOwner){result->
                when(result){
                    is NetworkResult.Error ->{
                        Toast.makeText(requireContext(),result.message,Toast.LENGTH_SHORT).show()
                        loadingDialogue.dismiss()

                    }
                    is NetworkResult.Loading -> {
                        loadingDialogue.show()

                    }
                    is NetworkResult.Success ->{
                        loadingDialogue.dismiss()
                        Toast.makeText(requireContext(),result.data,Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_addOffer_to_offers)
                    }
                    is NetworkResult.UnSpecified -> {

                    }
                }
            }
        }
    }

    private fun observeOfferValidationState() {
        lifecycleScope.launch {
            addOfferViewModel.offerstate.collect{state->
                if (state.offer is OfferValidation.Failure ){
                     binding.txtviewoffererror.text = state.offer.message
                }
            }
        }
    }

    private fun uploadOfferToFirebase() {
      binding.apply {
          uploadbtn.setOnClickListener {
              val offerId = db.collection(PARTNERS).document().id
              val imageurl = edttxtimageurl.text.toString().trim()
              val quote = edttxtbuttonquote.text.toString().trim()
              val cardcolor = edttxtcardcolor.text.toString().trim()
              val buttoncolor = edttxtbuttoncolor.text.toString().trim()
              val  buttontxtcolor = edttxtbuttontxtcolor.text.toString().trim()
              val descriptioncolor = edttxtdescriptioncolor.text.toString().trim()
              val description = edttxtdescription.text.toString().trim()
              val offer = OfferItem(offerId,imageurl,cardcolor,quote,buttoncolor,buttontxtcolor,description,descriptioncolor)
              addOfferViewModel.insertOfferIntoIntoFirebase(offer)
          }

      }
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


    override fun onDestroyView() {
        super.onDestroyView()
        addoffer =null
    }

}