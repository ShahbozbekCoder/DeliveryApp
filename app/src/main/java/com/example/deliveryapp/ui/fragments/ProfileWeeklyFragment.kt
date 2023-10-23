package com.example.deliveryapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.deliveryapp.R
import com.example.deliveryapp.databinding.FragmentProfileWeeklyBinding

class ProfileWeeklyFragment : Fragment() {

    private var _binding: FragmentProfileWeeklyBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfileWeeklyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val code = arguments?.getString("toWeekly")
        val code1 = arguments?.getString("toWeeklyFromDaily")
        val code2 = arguments?.getString("toWeeklyFromMonthly")

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}