package com.iovashvili.finalapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.iovashvili.finalapp.fragments.CartFragment
import com.iovashvili.finalapp.fragments.ItemsListScreen

class ViewPagerAdapter(fragment : FragmentActivity) : FragmentStateAdapter(fragment){
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return ItemsListScreen()
            1 -> return CartFragment()

        }
        return ItemsListScreen()
    }
}