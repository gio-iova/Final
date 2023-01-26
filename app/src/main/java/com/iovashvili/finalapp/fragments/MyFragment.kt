package com.iovashvili.finalapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.iovashvili.finalapp.adapter.ViewPagerAdapter
import com.iovashvili.finalapp.databinding.FragmentBlankBinding

class MyFragment : Fragment() {

    private lateinit var binding : FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater,container,false)

        binding.bottomNavigationView.setupWithNavController(findNavController())

        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when(position){
                0 -> tab.text = "Marketplace"
                1 -> tab.text = "Shopping cart"
            }

        }.attach()

        return binding.root
    }

}