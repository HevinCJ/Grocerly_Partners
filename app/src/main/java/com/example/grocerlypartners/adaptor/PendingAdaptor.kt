package com.example.grocerlypartners.adaptor

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.text.font.Typeface
import com.example.grocerlypartners.databinding.PendingRcLayoutBinding
import com.example.grocerlypartners.model.Order
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PendingAdaptor(
    private val onAccept:(Order) -> Unit,
    private val onCancel:(Order) -> Unit
): BaseOrderAdaptor() {


    inner class PendingViewHolder(private val binding: PendingRcLayoutBinding): BaseOrderViewHolder(binding.root){
        override fun bind(order: Order) {
            binding.apply {
                txtvieworderId.text = order.orderId

                txtviewaddress.text = buildString {
                    append(order.address.deliveryAddress)
                    append(" , ")
                    append(order.address.city)
                    append(" , ")
                    append(order.address.state)
                    append(" , ")
                    append(order.address.pinCode)
                }

                txtvieworders.text = buildString {
                    order.items.forEach {
                        append(it.product.itemName)
                        append(" × ")
                        append(it.quantity)
                        appendLine()
                    }
                }
                acceptbtn.setOnClickListener {
                    onAccept(order)
                }
                cancelbtn.setOnClickListener {
                    onCancel(order)
                }

                txviewordertime.text = calculateCurrentTime(order.timestamp)
                val method = order.paymentType
                val fullText = "Payment by: $method"
                txtviewpaymentmeth.text = SpannableString(fullText).apply {

                    val start = fullText.indexOf(method)
                    val end = start+method.length

                    setSpan(
                        StyleSpan(android.graphics.Typeface.BOLD),
                        start,
                        end,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }

            }
        }

        private fun calculateCurrentTime(timestamp: Long): String {
            val sdf = SimpleDateFormat("dd/MM/YY hh:mm a", Locale.getDefault())
            return sdf.format(Date(timestamp))
        }

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseOrderViewHolder {
        val binding = PendingRcLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PendingViewHolder(binding)
    }
}