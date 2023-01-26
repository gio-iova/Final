package com.iovashvili.finalapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.iovashvili.finalapp.R
import com.iovashvili.finalapp.databinding.FragmentBlankBinding
import com.iovashvili.finalapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        binding.button.setOnClickListener {
            Firebase.auth.signOut()
            findNavController().navigate(MyFragmentDirections.actionBlankFragmentToHomeScreen())
        }
        return binding.root
    }
}