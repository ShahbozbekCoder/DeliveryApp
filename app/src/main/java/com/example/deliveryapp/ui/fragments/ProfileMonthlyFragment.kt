package com.example.deliveryapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentProfileMonthlyBinding

class ProfileMonthlyFragment : Fragment() {

    private var _binding: FragmentProfileMonthlyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileMonthlyBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val code1 = arguments?.getString("toMonthlyFromDaily")
//        val code2 = arguments?.getString("toMonthlyFromWeekly")

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}