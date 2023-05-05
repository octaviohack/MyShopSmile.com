package com.example.myshop.activities.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.lifecycle.ViewModelProvider
//import com.example.myshop.activities.ui.home.HomeViewModel

import com.example.myshop.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {



    private var _binding: FragmentProductsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentProductsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root











    }

}