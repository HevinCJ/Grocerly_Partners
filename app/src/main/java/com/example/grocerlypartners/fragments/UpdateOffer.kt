package com.example.grocerlypartners.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.FragmentUpdateOfferBinding
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.utils.Constants.PARTNERS
import com.example.grocerlypartners.utils.LoadingDialogue
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.utils.OfferValidation
import com.example.grocerlypartners.viewmodel.UpdateOfferViewModel
import com.google.firebase.firestore.FirebaseFirestore
import com.skydoves.colorpickerview.ColorPickerDialog
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UpdateOffer : Fragment() {
    private var updateOffer:FragmentUpdateOfferBinding?=null
    private val binding get() = updateOffer!!

    @Inject
    lateinit var db:FirebaseFirestore

    private val args by navArgs<UpdateOfferArgs>()

    private val updateOfferViewModel:UpdateOfferViewModel by viewModels()

    private lateinit var loadingDialogue: LoadingDialogue

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       updateOffer = FragmentUpdateOfferBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDefaultOfferData()
        showPreviewToUser()
        setColorPickButtonForBackground()
        updateOfferInDb()
        observeUpdateOffer()
        loadingDialogue = LoadingDialogue(requireContext())
        observeOfferValidation()
    }

    private fun observeOfferValidation() {
       lifecycleScope.launch {
           updateOfferViewModel.isOfferValidated.collect {
               if (it.offer is OfferValidation.Failure) {
                   binding.apply {
                       txtviewoffererror.text = it.offer.message
                   }
               }
           }
       }
    }

    private fun observeUpdateOffer() {
        updateOfferViewModel.updateOffer.observe(viewLifecycleOwner){
            when(it){
                is NetworkResult.Error -> {
                    loadingDialogue.dismiss()
                    Toast.makeText(requireContext(),it.message,Toast.LENGTH_LONG).show()
                }
                is NetworkResult.Loading ->{
                    loadingDialogue.show()
                    binding.txtviewoffererror.text=""
                }
                is NetworkResult.Success -> {
                    findNavController().navigate(R.id.action_updateOffer_to_offers)
                    loadingDialogue.dismiss()
                }
                is NetworkResult.UnSpecified -> {

                }
            }
        }
    }

    private fun updateOfferInDb() {
        binding.apply {
            updateofferbtn.setOnClickListener {
                val offerId = args.offer.offerId
                val imageurl = edttxtimageurl.text.toString().trim()
                val quote = edttxtbuttonquote.text.toString().trim()
                val cardcolor = edttxtcardcolor.text.toString().trim()
                val buttoncolor = edttxtbuttoncolor.text.toString().trim()
                val  buttontxtcolor = edttxtbuttontxtcolor.text.toString().trim()
                val descriptioncolor = edttxtdescriptioncolor.text.toString().trim()
                val description = edttxtdescription.text.toString().trim()
                val offer = OfferItem(offerId,imageurl,cardcolor,quote,buttoncolor,buttontxtcolor,description,descriptioncolor)
                updateOfferViewModel.updateOfferIntoFb(offer)
            }

        }
    }

    private fun setDefaultOfferData() {
        binding.apply {

            val offer = args.offer
            edttxtimageurl.setText(offer.offerImage)
            edttxtcardcolor.setText(offer.offerBgColor)
            edttxtbuttoncolor.setText(offer.buttonBgColor)
            edttxtbuttonquote.setText(offer.buttonText)
            edttxtdescription.setText(offer.descriptionText)
            edttxtbuttontxtcolor.setText(offer.buttonTxtColor)
            edttxtdescriptioncolor.setText(offer.descriptionTextColor)
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
                    Toast.makeText(requireContext(),"Invalid Input", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        updateOffer = null
    }

}