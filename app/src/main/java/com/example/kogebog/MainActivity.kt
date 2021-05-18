package com.example.kogebog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dicerally.R
import com.example.dicerally.databinding.ActivityMainBinding
import com.example.kogebog.favouriteOption.FavouritesFragment
import com.example.kogebog.homeOption.RecipeFragment
import com.example.kogebog.shoppingOption.ShoppingFragment


class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment= RecipeFragment()
        val favoritesFragment= FavouritesFragment()
        val shoppingFragment= ShoppingFragment()
if(null==savedInstanceState){
        makeCurrentFragment(homeFragment)}

binding.bottomNavigation.setOnNavigationItemSelectedListener {
    when(it.itemId){
        R.id.ic_home ->makeCurrentFragment(homeFragment)
        R.id.ic_favorite ->makeCurrentFragment(favoritesFragment)
        R.id.ic_shop ->makeCurrentFragment(shoppingFragment)
    }
    true
}





}

    private fun makeCurrentFragment(fragment: Fragment) {
       supportFragmentManager.beginTransaction().apply {
           replace(R.id.fl_wrapper, fragment)
           addToBackStack(null)
           commit()
       }
    }




}