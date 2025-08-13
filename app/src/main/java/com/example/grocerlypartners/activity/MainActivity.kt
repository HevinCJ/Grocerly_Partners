package com.example.grocerlypartners.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.grocerlypartners.R
import com.example.grocerlypartners.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  private val  binding: ActivityMainBinding by lazy {
      ActivityMainBinding.inflate(layoutInflater)
  }
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        binding.btmnavgrocerly.setupWithNavController(navController)



        navController.addOnDestinationChangedListener{_,destination,_ ->
            when(destination.id){
                R.id.addProduct, R.id.addOffer, R.id.updateProduct,R.id.updateOffer,R.id.login,R.id.splash,R.id.signUp -> {
                    setBottomNavVisibility(false)
                }else -> {
                setBottomNavVisibility(true)
                }
            }
        }
    }



    override fun onSupportNavigateUp(): Boolean {
        return  navController.navigateUp()|| super.onSupportNavigateUp()
    }



    fun setBottomNavVisibility(isVisible: Boolean){
        binding.coordinatorLayout.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}

