package com.example.grocerlypartners.adaptor

import android.app.AlertDialog
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.grocerlypartners.databinding.AcceptedRcLayoutBinding
import com.example.grocerlypartners.model.CartProduct
import com.example.grocerlypartners.model.Order
import com.example.grocerlypartners.utils.OrderStatus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AcceptedAdaptor(
    private val onAccept:(Order) -> Unit,
    private val onDelete:(Order) -> Unit
): BaseOrderAdaptor() {

    private var cancelledItems: Map<String, List<CartProduct>> = emptyMap()


    inner class AcceptedViewHolder(private val binding: AcceptedRcLayoutBinding): BaseOrderViewHolder(binding.root){

        override fun bind(order: Order) {

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


            if (order.items.isEmpty() && cancelledItems.size > order.items.size && order.items.any { it.orderStatus == OrderStatus.ACCEPTED }){
                binding.materialcardviewcancelled.visibility = View.VISIBLE
                binding.materialCardView.visibility = View.INVISIBLE

                binding.apply {


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



    }
    private fun calculateCurrentTime(timestamp: Long): String {
        val sdf = SimpleDateFormat("dd/MM/YY hh:mm a", Locale.getDefault())
        return sdf.format(Date(timestamp))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseOrderViewHolder {
       val binding = AcceptedRcLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AcceptedViewHolder(binding)
    }

    fun setCancelledItems(items: Map<String, List<CartProduct>>){
        this.cancelledItems = items
        notifyDataSetChanged()
    }


}