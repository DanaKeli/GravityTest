package com.example.gravitytest.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.gravitytest.R
import com.example.gravitytest.databinding.ActivityMainBinding
import com.example.gravitytest.view.adapters.TabsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberOfTabs = 2
        tabsCustomisation()
        setViewPagerAdapter(numberOfTabs)
        linkLayoutAndPager()
    }


    private fun setViewPagerAdapter(numberOfTabs: Int) {
        val adapter = TabsPagerAdapter(supportFragmentManager, lifecycle, numberOfTabs)
        binding.tabsViewpager.adapter = adapter
        binding.tabsViewpager.isUserInputEnabled = true
    }

    private fun tabsCustomisation() {
        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        binding.tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        binding.tabLayout.tabMode = TabLayout.MODE_FIXED
    }


    private fun linkLayoutAndPager() {
        TabLayoutMediator(binding.tabLayout, binding.tabsViewpager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.write)
                }
                1 -> {
                    tab.text = getString(R.string.answers)

                }
            }
        }.attach()
    }
}