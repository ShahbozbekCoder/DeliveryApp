package com.example.deliveryapp.ui.fragments.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.deliveryapp.ui.fragments.ProfileDailyFragment
import com.example.deliveryapp.ui.fragments.ProfileMonthlyFragment
import com.example.deliveryapp.ui.fragments.ProfileWeeklyFragment

class FragmentPageAdapter(
    fragment: Fragment
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                ProfileMonthlyFragment()
            }
            1 -> {
                ProfileWeeklyFragment()
            }
            else -> {
                ProfileDailyFragment()
            }
        }
    }
}