package com.example.grocerlypartners.adaptor

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.grocerlypartners.databinding.ProductHomeRclayoutBinding
import com.example.grocerlypartners.model.OfferItem
import com.example.grocerlypartners.model.Product

class HomeAdaptor():RecyclerView.Adapter<HomeAdaptor.HomeViewHolder>() {

    private var products: List<Product> = emptyList()

    inner class HomeViewHolder(private val binding: ProductHomeRclayoutBinding):ViewHolder(binding.root){

        fun bindProduct(product: Product){
            binding.product = product
            binding.executePendingBindings()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return  HomeViewHolder(ProductHomeRclayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
       val currentProduct= products[position]
        holder.bindProduct(currentProduct)
    }

    fun setProduct(product:List<Product>){
        this.products = product
        notifyDataSetChanged()
        Log.d("isdatainrcview",product.toString())
    }

    fun getProduct(position: Int): Product {
        return products[position]
    }


}