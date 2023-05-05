package com.example.myshop.activities.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
//import androidx.lifecycle.ViewModelProvider
//import com.example.myshop.activities.ui.notifications.NotificationsViewModel
import com.example.myshop.databinding.FragmentOrdersBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class OrdersFragment : Fragment() {



    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root






    }


}