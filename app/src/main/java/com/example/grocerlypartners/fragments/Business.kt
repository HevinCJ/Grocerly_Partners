package com.example.grocerlypartners.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.FragmentBusinessBinding
import com.example.grocerlypartners.model.BusinessUiState
import com.example.grocerlypartners.model.SalesStatus
import com.example.grocerlypartners.utils.NetworkResult
import com.example.grocerlypartners.viewmodel.BusinessViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.launch
import kotlin.math.abs

@AndroidEntryPoint
class Business : Fragment() {
    private var business: FragmentBusinessBinding?=null
    private val binding get() = business!!

    private val businessViewModel: BusinessViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       business = FragmentBusinessBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeBusinessUiState()
    }

    private fun observeBusinessUiState() {
        viewLifecycleOwner.lifecycleScope.launch {
            businessViewModel.businessUiState.filterIsInstance<BusinessUiState>().collectLatest { uiState ->
                when(uiState){
                    is BusinessUiState.CancelledOrderAmount -> {
                       if ( uiState.totalAmount is NetworkResult.Success){
                           binding.totalcancelledamount.text = uiState.totalAmount.data.toString()
                       }

                        if ( uiState.totalAmount is NetworkResult.Error){
                            Toast.makeText(requireContext(), uiState.totalAmount.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                    is BusinessUiState.CancelledOrderSize -> {
                        if ( uiState.totalSize is NetworkResult.Success){
                            binding.totalcancelledordersize.text = uiState.totalSize.data.toString()
                        }
                        if ( uiState.totalSize is NetworkResult.Error){
                            Toast.makeText(requireContext(), uiState.totalSize.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                    is BusinessUiState.TotalActiveOrderAmount -> {
                        if ( uiState.totalAmount is NetworkResult.Success){
                            binding.totalorderamount.text = uiState.totalAmount.data.toString()
                        }

                        if ( uiState.totalAmount is NetworkResult.Error){
                            Toast.makeText(requireContext(), uiState.totalAmount.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                    is BusinessUiState.TotalOrderSize -> {
                        if ( uiState.totalSize is NetworkResult.Success){
                            binding.totalordersize.text = uiState.totalSize.data.toString()
                        }

                        if ( uiState.totalSize is NetworkResult.Error){
                            Toast.makeText(requireContext(), uiState.totalSize.message, Toast.LENGTH_SHORT).show()
                        }
                    }

                    is BusinessUiState.SalesComparison -> {
                        if (uiState.comparisonResult is NetworkResult.Success){

                            uiState.comparisonResult.data?.let {
                                when(it.status){
                                    SalesStatus.INCREASE -> {
                                        binding.apply {
                                            imgviewpercentageamount.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.increase))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                           val  txtEdited = SpannableString(fulltext).apply {

                                               setSpan(
                                                   ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.green)),
                                                   0,
                                                   coloredPart.length,
                                                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                               )

                                               setSpan(
                                                   StyleSpan(Typeface.BOLD),
                                                   0,
                                                   coloredPart.length,
                                                   Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                               )

                                            }
                                            txtviewsalespercentageamount.text = txtEdited
                                        }
                                    }
                                    SalesStatus.DECREASE -> {
                                        binding.apply {
                                            imgviewpercentageamount.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.decrease))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.red)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewsalespercentageamount.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_CHANGE ->{
                                        binding.apply {
                                            imgviewpercentageamount.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.repeaticon))
                                            val coloredPart = it.percentageChange.toString()
                                            val fulltext = "No Change "
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.black)),
                                                    0,
                                                    fulltext.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewsalespercentageamount.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_PRIOR_DATA -> {
                                        binding.apply {
                                            imgviewpercentageamount.visibility = View.INVISIBLE
                                            txtviewsalespercentageamount.visibility = View.INVISIBLE
                                        }
                                    }
                                }
                            }

                        }
                    }

                    is BusinessUiState.SalesComparisonCancelled -> {
                        if (uiState.comparisonResult is NetworkResult.Success){

                            uiState.comparisonResult.data?.let {
                                when(it.status){
                                    SalesStatus.INCREASE -> {
                                        binding.apply {
                                            imgviewpercentagecancelledamount.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.increasecancelled))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.red)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewcancelledpercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.DECREASE -> {
                                        binding.apply {
                                            imgviewpercentagecancelledamount.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.decreasecancelled))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.green)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewcancelledpercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_CHANGE ->{
                                        binding.apply {
                                            imgviewpercentagecancelledamount.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.repeaticon))
                                            val coloredPart = it.percentageChange.toString()
                                            val fulltext = "No Change "
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.black)),
                                                    0,
                                                    fulltext.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewcancelledpercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_PRIOR_DATA -> {
                                        binding.apply {
                                            imgviewpercentagecancelledamount.visibility = View.INVISIBLE
                                            txtviewcancelledpercentage.visibility = View.INVISIBLE
                                        }
                                    }
                                }
                            }

                        }
                    }
                    is BusinessUiState.SalesComparisonCancelledSize -> {
                        if (uiState.comparisonResult is NetworkResult.Success){

                            uiState.comparisonResult.data?.let {
                                when(it.status){
                                    SalesStatus.INCREASE -> {
                                        binding.apply {
                                            imgviewpercentagecancelled.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.increasecancelled))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.red)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewcancelledsizepercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.DECREASE -> {
                                        binding.apply {
                                            imgviewpercentagecancelled.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.decreasecancelled))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.green)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewcancelledsizepercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_CHANGE ->{
                                        binding.apply {
                                            imgviewpercentagecancelled.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.repeaticon))
                                            val coloredPart = it.percentageChange.toString()
                                            val fulltext = "No Change "
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.black)),
                                                    0,
                                                    fulltext.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewcancelledsizepercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_PRIOR_DATA -> {
                                        binding.apply {
                                            imgviewpercentagecancelled.visibility = View.INVISIBLE
                                            txtviewcancelledsizepercentage.visibility = View.INVISIBLE
                                        }
                                    }
                                }
                            }

                        }
                    }
                    is BusinessUiState.SalesComparisonSize -> {
                        if (uiState.comparisonResult is NetworkResult.Success){

                            uiState.comparisonResult.data?.let {
                                when(it.status){
                                    SalesStatus.INCREASE -> {
                                        binding.apply {
                                            imgviewpercentageorders.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.increase))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.green)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewtotalorderspercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.DECREASE -> {
                                        binding.apply {
                                            imgviewpercentageorders.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.decrease))
                                            val coloredPart = "%.1f%%".format(abs(it.percentageChange))
                                            val remaining = " vs Yesterday"
                                            val fulltext = coloredPart+remaining
                                            val  txtEdited = SpannableString(fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.red)),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                                setSpan(
                                                    StyleSpan(Typeface.BOLD),
                                                    0,
                                                    coloredPart.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewtotalorderspercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_CHANGE ->{
                                        binding.apply {
                                            imgviewpercentageorders.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.repeaticon))
                                            val coloredPart = it.percentageChange.toString()
                                            val fulltext = "No Change"
                                            val  txtEdited = SpannableString( fulltext).apply {

                                                setSpan(
                                                    ForegroundColorSpan(ContextCompat.getColor(requireContext(),R.color.black)),
                                                    0,
                                                    fulltext.length,
                                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                                                )

                                            }
                                            txtviewtotalorderspercentage.text = txtEdited
                                        }
                                    }
                                    SalesStatus.NO_PRIOR_DATA -> {
                                        binding.apply {
                                            imgviewpercentageorders.visibility = View.INVISIBLE
                                            txtviewtotalorderspercentage.visibility = View.INVISIBLE
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
    }


}