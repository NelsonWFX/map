package com.wanaot.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wanaot.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_nav_home -> binding.viewPager2.setCurrentItem(0, false)
                R.id.bottom_nav_shop -> binding.viewPager2.setCurrentItem(1, false)
                R.id.bottom_nav_product -> binding.viewPager2.setCurrentItem(2, false)
                R.id.bottom_nav_my -> binding.viewPager2.setCurrentItem(3, false)
            }
            true
        }

        val adapter = HomePagerAdapter(supportFragmentManager, lifecycle)
        val mViewPager = binding.viewPager2
        mViewPager.isUserInputEnabled = false
        mViewPager.adapter = adapter


    }

    class HomePagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle?) : FragmentStateAdapter(fragmentManager, lifecycle!!) {
        var tabFragmentsCreators: Array<Fragment> = arrayOf(MapFragment(), TextFragment(), TextFragment(), TextFragment())
        override fun createFragment(position: Int): Fragment {
            return tabFragmentsCreators[position]
        }

        override fun getItemCount(): Int {
            return tabFragmentsCreators.size
        }

    }
}