package com.example.grocerlypartners.adaptor

import android.app.AlertDialog
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.grocerlypartners.databinding.ReadyRcLayoutBinding
import com.example.grocerlypartners.model.CartProduct
import com.example.grocerlypartners.model.Order
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ReadyAdaptor(
    private val onAccept:(Order) -> Unit,
    private val onDelete:(Order) -> Unit
): BaseOrderAdaptor() {

    private var cancelledItems: Map<String, List<CartProduct>> = emptyMap()

    inner class ReadyViewHolder(private val binding: ReadyRcLayoutBinding): BaseOrderViewHolder(binding.root){
        override fun bind(order: Order) {
           if (!order.isFullyCancelledForSeller){
               binding.apply {
                   materialcardviewcancelled.visibility = View.INVISIBLE
                   materialCardView.visibility = View.VISIBLE

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
                           appendLine(it.product.itemName + " × " + it.quantity)
                       }
                   }
                   acceptbtn.setOnClickListener {
                       onAccept(order)
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

                   val cancelledForThisOrder = cancelledItems[order.orderId].orEmpty()

                   if (cancelledForThisOrder.isNotEmpty()) {
                       txtviewcancelled.visibility = View.VISIBLE
                       cancelleditemsorders.visibility = View.VISIBLE

                       cancelleditemsorders.text = buildString {
                           cancelledForThisOrder.forEach {
                               Log.d("TAGcancelled", "bind: ${it.product.itemName}")
                               appendLine(it.product.itemName + " × " + it.quantity)
                           }
                       }
                   } else {
                       txtviewcancelled.visibility = View.GONE
                       cancelleditemsorders.visibility = View.GONE
                   }

               }
           }else{
               binding.apply {
                   binding.txtvieworderidcancelled.text = order.orderId
                   materialcardviewcancelled.visibility = View.VISIBLE
                   materialCardView.visibility = View.INVISIBLE


                   cancelleddeletebtn.setOnClickListener {
                       AlertDialog.Builder(binding.root.context)
                           .setTitle("Delete Order")
                           .setMessage("Are you sure to delete the order?")
                           .setPositiveButton("Yes"){dialogue,which->
                               onDelete(order)
                               dialogue.cancel()
                           }

                           .setNegativeButton("No"){dialogue,which->

                               dialogue.cancel()
                           }
                           .show()
                   }
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
        val binding = ReadyRcLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ReadyViewHolder(binding)
    }

    fun setCancelledItems(items:Map<String, List<CartProduct>>){
        this.cancelledItems = items
        notifyDataSetChanged()
    }
}