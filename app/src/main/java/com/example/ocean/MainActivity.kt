package com.example.ocean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.ocean.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

//    ActivityMainBinding binding

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(watchlistFragment())

        // till now we have implemented viewbinding

//        setContentView(R.layout.activity_main)   previously line was this.

//        Now applying on Click event Listener on our menu items.

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.watchlist -> replaceFragment(watchlistFragment())
                R.id.orders -> replaceFragment(ordersFragment())
                R.id.portfolio -> replaceFragment(portfolioFragment())
                R.id.funds -> replaceFragment(fundsFragment())

                else -> {}

            }
            true
        }

//        binding = ActivityMainBinding.inflate(layoutInflater());
//        setContentView(binding.getRoot());

//        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//
//            switch(item.getItemID()){
//                case R.id.watchlist:
//                        break;
//
//                case R.id.orders:
//                        break;
//
//                case R.id.portfolio:
//                        break;
//
//                case R.id.funds:
//                        break;
//            }
//
//            return true;
//        })

    }
    // now we are creating method to replace fram layout
    // replacing fram layout with fragment. We used fragmentManager to transact frameLayout with the fragment that we will get as an argument
    // in replaceFragment() functionl.
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }
}