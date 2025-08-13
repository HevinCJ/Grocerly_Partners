package com.example.grocerlypartners.adaptor

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.grocerlypartners.fragments.Accepted
import com.example.grocerlypartners.fragments.Pending
import com.example.grocerlypartners.fragments.Ready
import com.example.grocerlypartners.fragments.Shipped

class OrdersPagerAdaptor(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun createFragment(position: Int): Fragment {
     return   when(position){
            0 -> Pending()
            1 -> Accepted()
            2 -> Ready()
            3 -> Shipped()
         else -> Pending()

     }
    }

    override fun getItemCount(): Int {
       return 4
    }


}