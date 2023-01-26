package com.iovashvili.finalapp.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.iovashvili.finalapp.adapter.ShoppingListAdapter
import com.iovashvili.finalapp.databinding.FragmentItemsListScreenBinding
import com.iovashvili.finalapp.model.ShopListItem
import com.google.firebase.database.*

class ItemsListScreen : Fragment() {
    private lateinit var binding: FragmentItemsListScreenBinding
    private lateinit var db: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.e("AUTH", "LOGGED")


        val adapter = ShoppingListAdapter(mutableListOf(), onClick = {
            findNavController().navigate(
                MyFragmentDirections.actionBlankFragmentToDetailsScreen(
                    it
                )
            )
        })
        db = FirebaseDatabase.getInstance().getReference("items")
        db.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {

            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onDataChange(snapshot: DataSnapshot) {
                val children = snapshot.children
                children.forEach {
                    val item = it.getValue(ShopListItem::class.java)
                    adapter.items.add(item!!)
                    adapter.notifyDataSetChanged()

                    binding.progressBar.visibility = View.GONE

                }
            }
        })

        binding = FragmentItemsListScreenBinding.inflate(layoutInflater)

        binding.itemsRV.layoutManager = LinearLayoutManager(context)
        binding.itemsRV.adapter = adapter



        return binding.root
    }

}