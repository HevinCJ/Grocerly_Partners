package com.example.grocerlypartners.adaptor

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.grocerlypartners.utils.ProductCategory

object BindingAdaptors {


    @BindingAdapter("android:parseCategoryIntoString")
    @JvmStatic
    fun parseCategoryIntoString(view:TextView, category: ProductCategory){
        val categoryInString = convertCategoryIntoString(category)
        view.text = categoryInString
    }


   private fun convertCategoryIntoString(category: ProductCategory):String{
        return when(category){
            ProductCategory.selectcatgory -> "Select a Category"
            ProductCategory.FruitsandVegies -> "Fruits & Vegies"
            ProductCategory.FrozenFoods -> "Frozen Foods"
            ProductCategory.BreadandBakery -> "Bread & Bakery"
            ProductCategory.PersonalCare -> "Personal Care"
            ProductCategory.Households -> "House Holds"
            ProductCategory.HealthCare -> "Health Care"
            ProductCategory.Meat -> "Meat"
        }
   }


    @BindingAdapter("android:setImageToView")
    @JvmStatic
    fun setImageToView(view:ImageView,src:String){
        val imageUri = Uri.parse(src)

        Glide.with(view.context)
            .load(src)
            .into(view)

    }

}