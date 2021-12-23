package com.example.gravitytest.view.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gravitytest.view.activity.AnswersFragment
import com.example.gravitytest.view.activity.WriteFragment

class TabsPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, private var numberOfTabs: Int) :
    FragmentStateAdapter(fm, lifecycle) {
    private lateinit var bundle: Bundle

    override fun getItemCount(): Int {
        return numberOfTabs
    }

    override fun createFragment(position: Int): Fragment {
        bundle = Bundle()
        return when (position) {
            0 -> WriteFragment()
            1 -> AnswersFragment()
            else -> WriteFragment()
        }
    }
}