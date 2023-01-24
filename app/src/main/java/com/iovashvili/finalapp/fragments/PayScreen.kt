package com.iovashvili.finalapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.iovashvili.finalapp.databinding.FragmentPayScreenBinding

class PayScreen : Fragment() {
    private lateinit var binding: FragmentPayScreenBinding
    private val item: PayScreenArgs by navArgs()
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPayScreenBinding.inflate(layoutInflater)
        binding.successTV.text = "You have successfully purchased ${item.shopItem.name}"
        return binding.root
    }
}