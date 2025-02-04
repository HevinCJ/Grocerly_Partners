package com.example.grocerlypartners.fragments

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.FragmentAddProductBinding
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.model.Product
import com.example.grocerlypartners.utils.ProductCategory
import com.example.grocerlypartners.utils.ProductValidation
import com.example.grocerlypartners.viewmodel.AddProductViewModel
import com.google.firebase.Firebase
import com.google.firebase.app
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

@AndroidEntryPoint
class AddProduct : Fragment() {
    private var addProduct: FragmentAddProductBinding? = null
    private val binding get() = addProduct!!

    private val addProductViewModel: AddProductViewModel by viewModels()
    private var selectedImage: String? = null

    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            try {

                selectedImage = uri.toString()
                binding.imgviewitemimg.setImageURI(uri)

            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            selectedImage = null
            binding.imgviewitemimg.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.weebly_image_sample
                )
            )
        }


    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        addProduct = FragmentAddProductBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCategoriesSpinner()
        uploadDataToFirebase()
        getImageFromStorage()
        observeUploadState()
        observeProductValidationState()
    }

    private fun observeProductValidationState() {
        lifecycleScope.launch {
            addProductViewModel.productValState.collect {
                if (it.product is ProductValidation.failure) {
                    binding.txtviewerror.text = it.product.message
                }

            }
        }
    }

    private fun observeUploadState() {
        lifecycleScope.launch {
            addProductViewModel.uploadProduct.collect {
                when (it) {
                    is NetworkResult.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }

                    is NetworkResult.Loading -> {
                        binding.txtviewerror.text = ""
                        Toast.makeText(requireContext(), "Loading Please wait", Toast.LENGTH_SHORT)
                            .show()
                    }

                    is NetworkResult.Success -> {
                        Toast.makeText(requireContext(), it.data, Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_addProduct_to_home)
                    }

                    is NetworkResult.UnSpecified -> {

                    }
                }
            }
        }
    }

    private fun setUpCategoriesSpinner() {
        val categoryItems = ProductCategory.entries.map { it.displayName }
        val adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categoryItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.CategorySpinner.adapter = adapter
    }

    private fun uploadDataToFirebase() {
        binding.apply {
            publishbtn.setOnClickListener {
                val itemname = edttextname.text.toString().trim()
                val itemprice = edttextprice.text.toString().trim().toIntOrNull()
                val imageuri = selectedImage
                val selectedItem = addProductViewModel.parseStringIntoProduct(CategorySpinner.selectedItem.toString())
                val product = Product(imageuri, itemname, itemprice, selectedItem)
                addProductViewModel.uploadProductToFirebase(product)
            }
        }
    }

    private fun getImageFromStorage() {
        binding.apply {
            imgviewitemimg.setOnClickListener {
                galleryLauncher.launch("image/*")
            }
        }
    }


    private fun saveImageInRequiredFormat(bitmap: Bitmap, fileName: String, format: String): File {
        try {

            val file = File(requireContext().filesDir, "$fileName.$format")

             FileOutputStream(file).use {fos->
                 bitmap.compress(if (format=="png")  Bitmap.CompressFormat.PNG  else Bitmap.CompressFormat.JPEG,100,fos)
             }
          return  file

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return File("")
    }



}